package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkerDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoPermissionException;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoSuchEntityException;
import com.gmail.kirilllapitsky.deliverycaffee.filter.UserFilterSettings;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    public UserDto find(User requestUser, String login, Optional<Long> cafeId) throws NoSuchEntityException, NoPermissionException {
        Cafe cafe = null;
        switch (requestUser.getRole()) {
            case ADMINISTRATOR:
                if (cafeId.isPresent())
                    cafe = cafeRepository.findById(cafeId.get()).orElseThrow(() -> new NoSuchEntityException("no such cafe."));
                break;
            case MANAGER:
                if (requestUser.getCafe() != null)
                    cafe = cafeRepository.findById(requestUser.getCafe().getId()).orElseThrow(() -> new NoSuchEntityException("no such cafe."));
                break;
            default: {
                throw new NoPermissionException("no permissions");
            }
        }
        if (cafe != null)
            return Mapper.map(userRepository.findByLoginAndCafe(login, cafe).orElseThrow(() -> new NoSuchEntityException("no such user.")), UserDto.class);
        else if (requestUser.getRole() == Role.ADMINISTRATOR)
            return Mapper.map(userRepository.findByLogin(login).orElseThrow(() -> new NoSuchEntityException("no such user.")), UserDto.class);
        throw new NoSuchEntityException("no such cafe.");
    }

    public List<UserDto> findByCafe(Long cafeId, Pageable pageable) {
        return Mapper.mapList(userRepository.findAllByCafe(cafeRepository.findById(cafeId).orElseThrow(), pageable), UserDto.class);
    }

    public List<UserDto> findFiltered(User requestUser, UserFilterSettings userFilterSettings, Pageable pageable) throws NoPermissionException, NoSuchEntityException {
        switch (requestUser.getRole()) {
            case ADMINISTRATOR:
                break;
            case MANAGER: {
                if (userFilterSettings.getRole().get() == Role.ADMINISTRATOR)
                    throw new NoPermissionException("no permissions");
            }
            break;
            default: {
                throw new NoPermissionException("no permissions");
            }
        }
        if (userFilterSettings.getCafeId().isPresent() && userFilterSettings.getRole().isPresent()) {
            Cafe cafe = cafeRepository.findById(userFilterSettings.getCafeId().get()).orElseThrow(() -> new NoSuchEntityException("no such cafe."));
            return Mapper.mapList(userRepository.findAllByRoleAndCafe(userFilterSettings.getRole().get(), cafe, pageable), UserDto.class);
        } else if (userFilterSettings.getRole().isPresent()) {
            return Mapper.mapList(userRepository.findAllByRole(userFilterSettings.getRole().get(), pageable), UserDto.class);
        } else if (userFilterSettings.getCafeId().isPresent()) {
            Cafe cafe = cafeRepository.findById(userFilterSettings.getCafeId().get()).orElseThrow(() -> new NoSuchEntityException("no such cafe."));
            return Mapper.mapList(userRepository.findAllByCafe(cafe, pageable), UserDto.class);
        }
        return Collections.emptyList();
    }

    public UserDto create(NewWorkerDto newWorkerDto, User requestUser) throws Exception {
        Cafe cafe;
        switch (requestUser.getRole()) {
            case ADMINISTRATOR:
                if (newWorkerDto.getCafeId() != null)
                    cafe = cafeRepository.findById(newWorkerDto.getCafeId()).orElseThrow(() -> new NoSuchEntityException("no such cafe."));
                else
                    throw new Exception("cafe id is not specified");
                break;
            case MANAGER:
                if (newWorkerDto.getRole() == Role.ADMINISTRATOR)
                    throw new NoPermissionException("no permissions");
                cafe = requestUser.getCafe();
                break;
            default: {
                throw new NoPermissionException("no permissions");
            }
        }
        if (cafe != null) {
            User user = Mapper.map(newWorkerDto, User.class);
            user.setCafe(cafe);
            return Mapper.map(userRepository.save(user), UserDto.class);
        }
        throw new Exception("cafe id is not specified");
    }
}
