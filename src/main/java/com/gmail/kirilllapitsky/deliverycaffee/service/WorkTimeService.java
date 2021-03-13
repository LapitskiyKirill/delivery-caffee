package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkTimeDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.WorkTime;
import com.gmail.kirilllapitsky.deliverycaffee.repository.WorkTimeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkTimeService {
    private final WorkTimeRepository workTimeRepository;

    public WorkTime save(NewWorkTimeDto newWorktimeDto, Cafe cafe) {
        WorkTime workTime = Mapper.map(newWorktimeDto, WorkTime.class);
        workTime.setCafe(cafe);
        workTime.getDayWorkTimes().forEach(d -> d.setCafeWorkTime(workTime));
        return workTimeRepository.save(workTime);
    }
}
