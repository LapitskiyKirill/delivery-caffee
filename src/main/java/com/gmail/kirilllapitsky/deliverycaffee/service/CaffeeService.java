package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.CaffeeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.EditCaffeeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewCaffeeDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Caffee;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CaffeeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaffeeService {
    private final CaffeeRepository caffeeRepository;

    public CaffeeDto find(Long id) {
        return Mapper.map(caffeeRepository.findById(id).orElseThrow(), CaffeeDto.class);
    }

    public CaffeeDto create(NewCaffeeDto newCaffeeDto) {
        return Mapper.map(
                caffeeRepository.save(Mapper.map(newCaffeeDto, Caffee.class)),
                CaffeeDto.class
        );
    }

    public void edit(EditCaffeeDto editCaffeeDto) {
        Caffee caffee = caffeeRepository.findById(editCaffeeDto.getId()).orElseThrow();
        caffee.setName(editCaffeeDto.getName());
        caffee.setAddress(editCaffeeDto.getAddress());
        caffee.setWorkTime(editCaffeeDto.getWorkTime());
        caffeeRepository.save(caffee);
    }
}
