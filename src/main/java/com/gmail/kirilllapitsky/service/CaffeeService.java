package com.gmail.kirilllapitsky.service;

import com.gmail.kirilllapitsky.dto.CaffeeDto;
import com.gmail.kirilllapitsky.dto.UserDto;
import com.gmail.kirilllapitsky.entity.Caffee;
import com.gmail.kirilllapitsky.repository.CaffeeRepository;
import com.gmail.kirilllapitsky.util.Mapper;
import org.springframework.stereotype.Service;

@Service
public class CaffeeService {
    private final CaffeeRepository caffeeRepository;

    public CaffeeService(CaffeeRepository caffeeRepository) {
        this.caffeeRepository = caffeeRepository;
    }

    public CaffeeDto find(Long id) {
        return Mapper.map(caffeeRepository.findById(id).orElseThrow(), CaffeeDto.class);
    }
}
