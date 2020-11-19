package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.RegisterCustomerDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.exception.RegistrationException;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationCustomerService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(RegisterCustomerDto customerDto) throws RegistrationException {
        if (userRepository.findByLogin(customerDto.getLogin()).isPresent()) {
            throw new RegistrationException("client with such login already exist");
        }
        customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));

        this.userRepository.save(Mapper.map(customerDto, User.class));
    }
}
