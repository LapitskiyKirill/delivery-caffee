package com.gmail.kirilllapitsky.service;

import com.gmail.kirilllapitsky.dto.CaffeeDto;
import com.gmail.kirilllapitsky.dto.EditCaffeeDto;
import com.gmail.kirilllapitsky.dto.NewCaffeeDto;
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

    public void create(NewCaffeeDto newCaffeeDto) {
        caffeeRepository.save(new Caffee(
                newCaffeeDto.getName(),
                newCaffeeDto.getAddress(),
                newCaffeeDto.getWorkTime()
        ));
    }

    public void edit(EditCaffeeDto editCaffeeDto) {
        Caffee caffee = caffeeRepository.findById(editCaffeeDto.getId()).orElseThrow();
        caffee.setName(editCaffeeDto.getName());
        caffee.setAddress(editCaffeeDto.getAddress());
        caffee.setWorkTime(editCaffeeDto.getWorkTime());
        caffeeRepository.save(caffee);
    }
}
