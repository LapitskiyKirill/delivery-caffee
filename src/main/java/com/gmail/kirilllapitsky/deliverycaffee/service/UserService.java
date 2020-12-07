package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.EditWorkerDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkerDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserFilterSettings;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoPermissionException;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoSuchEntityException;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CafeRepository cafeRepository;

    public void updateRole(Long id, Role role) {
        User user = userRepository.findById(id).orElseThrow();
        user.setRole(role);
        userRepository.save(user);
    }

    public List<UserDto> find(UserFilterSettings userFilterSettings, Pageable pageable) throws NoSuchEntityException {
        Cafe cafe = null;
        if (userFilterSettings.getCafeId() != null)
            cafe = cafeRepository.findById(userFilterSettings.getCafeId()).orElseThrow(() -> new NoSuchEntityException("no such cafe."));
        return Mapper.mapList(
                userRepository.findUserByRoleAndCafeAndLogin(
                        userFilterSettings.getLogin(),
                        userFilterSettings.getRole(),
                        cafe,
                        pageable),
                UserDto.class
        );
    }

    public UserDto create(User requestUser, NewWorkerDto newWorkerDto) throws Exception {
        switch (requestUser.getRole()) {
            case ADMINISTRATOR:
                return createByAdministrator(newWorkerDto);
            case MANAGER:
                return createByManager(newWorkerDto, requestUser.getCafe());
        }
        throw new NoPermissionException("no permissions.");
    }

    public UserDto createByAdministrator(NewWorkerDto newWorkerDto) throws NoSuchEntityException {
        Cafe cafe = cafeRepository.findById(newWorkerDto.getCafeId()).orElseThrow(() -> new NoSuchEntityException("no such cafe."));
        User user = Mapper.map(newWorkerDto, User.class);
        user.setCafe(cafe);
        return Mapper.map(userRepository.save(user), UserDto.class);
    }

    public UserDto createByManager(NewWorkerDto newWorkerDto, Cafe cafe) {
        User user = Mapper.map(newWorkerDto, User.class);
        user.setCafe(cafe);
        return Mapper.map(userRepository.save(user), UserDto.class);
    }

    public UserDto edit(EditWorkerDto editWorkerDto) throws NoSuchEntityException {
        userRepository.findById(editWorkerDto.getId()).orElseThrow(() -> new NoSuchEntityException("no such worker."));
        Cafe cafe = cafeRepository.findById(editWorkerDto.getCafeId()).orElseThrow(() -> new NoSuchEntityException("no such cafe."));
        User worker = Mapper.map(editWorkerDto, User.class);
        worker.setCafe(cafe);
        return Mapper.map(userRepository.save(worker), UserDto.class);
    }

    public void delete(Long userId) throws NoSuchEntityException {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchEntityException("no such user."));
        userRepository.delete(user);
    }
}
