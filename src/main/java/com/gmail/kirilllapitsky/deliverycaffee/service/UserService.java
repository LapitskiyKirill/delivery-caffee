package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

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

    public UserDto find(String login, Optional<Long> cafeId) {
        if (cafeId.isPresent()) {
            Cafe cafe = cafeRepository.findById(cafeId.get()).orElseThrow();
            User user = userRepository.findByLoginAndCafe(login, cafe).orElseThrow();
            return Mapper.map(user, UserDto.class);
        }
        return Mapper.map(userRepository.findByLogin(login).orElseThrow(), UserDto.class);
    }

    public List<UserDto> findByCafe(Long cafeId, Pageable paging) {
        return Mapper.mapList(userRepository.findAllByCafe(cafeRepository.findById(cafeId).orElseThrow(), paging), UserDto.class);
    }

}
