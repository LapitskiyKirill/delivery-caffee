package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.CafeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewCafeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkTimeDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.WorkTime;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;
    private final WorkTimeService workTimeService;

    public CafeDto find(Long id) {
        return Mapper.map(cafeRepository.findById(id).orElseThrow(), CafeDto.class);
    }

    public void create(NewCafeDto newCafeDto) {
        cafeRepository.save(Mapper.map(newCafeDto, Cafe.class));
    }

    public void setWorkTime(NewWorkTimeDto newWorkTimeDto) {
        Cafe cafe = cafeRepository.findById(newWorkTimeDto.getCafeId()).orElseThrow();
        WorkTime workTime = workTimeService.save(newWorkTimeDto, cafe);
        cafe.setWorkTime(workTime);
        cafeRepository.save(cafe);
    }
}
