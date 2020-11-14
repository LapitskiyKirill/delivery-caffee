package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.CafeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.EditCafeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewCafeDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;

    public CafeDto find(Long id) {
        return Mapper.map(cafeRepository.findById(id).orElseThrow(), CafeDto.class);
    }

    public CafeDto create(NewCafeDto newCafeDto) {
        return Mapper.map(
                cafeRepository.save(Mapper.map(newCafeDto, Cafe.class)),
                CafeDto.class
        );
    }

    public void edit(EditCafeDto editCafeDto) {
        Cafe cafe = cafeRepository.findById(editCafeDto.getId()).orElseThrow();
        cafe.setName(editCafeDto.getName());
        cafe.setAddress(editCafeDto.getAddress());
        cafe.setWorkTime(editCafeDto.getWorkTime());
        cafeRepository.save(cafe);
    }
}
