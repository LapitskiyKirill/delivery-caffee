package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CafeRepository cafeRepository;

    public void setRole(Long id, Role role) {
        User user = userRepository.findById(id).orElseThrow();
        user.setRole(role);
        userRepository.save(user);
    }

    public UserDto findByLogin(String login) {
        return Mapper.map(userRepository.findByLogin(login).orElseThrow(), UserDto.class);
    }

    public List<UserDto> findByCafe(Long cafeId) {
        return Mapper.mapList(userRepository.findAllByCafe(cafeRepository.findById(cafeId).orElseThrow()), UserDto.class);
    }

    public void setCafe(Long userId, Long cafeId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setCafe(cafeRepository.findById(cafeId).orElseThrow());
        userRepository.save(user);
    }
}
