package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CaffeeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class    UserService {
    private final UserRepository userRepository;
    private final CaffeeRepository caffeeRepository;

    public void setRole(Long id, Role role) {
        User user = userRepository.findById(id).orElseThrow();
        user.setRole(role);
        userRepository.save(user);
    }

    public UserDto findByLogin(String login) {
        return Mapper.map(userRepository.findByLogin(login), UserDto.class);
    }

    public List<UserDto> findByCaffee(Long caffeeId) {
        return Mapper.mapList(userRepository.findAllByCaffee(caffeeRepository.findById(caffeeId).orElseThrow()), UserDto.class);
    }

    public void setCaffee(Long userId, Long caffeeId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setCaffee(caffeeRepository.findById(caffeeId).orElseThrow());
        userRepository.save(user);
    }
}
