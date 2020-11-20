package com.gmail.kirilllapitsky.deliverycaffee;

import com.gmail.kirilllapitsky.deliverycaffee.dto.DayWorkTimeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkTimeDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.WorkTime;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Days;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.service.WorkTimeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WorkTimeServiceTest extends ServiceTest {

    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    private WorkTimeService workTimeService;

    @Test
    public void shouldSaveNewWorkTime() {
        Cafe cafe = TestData.getCafe();
        cafeRepository.save(cafe);
        List<DayWorkTimeDto> dayWorkTimes = TestData.getDayWorkTimeDto();
        WorkTime workTime = workTimeService.save(new NewWorkTimeDto(cafe.getId(), dayWorkTimes), cafe);
        assertEquals(workTime.getDayWorkTimes().size(), 4);
    }

    @Test
    public void shouldHaveCafe() {
        Cafe cafe = TestData.getCafe();
        cafeRepository.save(cafe);
        List<DayWorkTimeDto> dayWorkTimes = TestData.getDayWorkTimeDto();
        WorkTime workTime = workTimeService.save(new NewWorkTimeDto(cafe.getId(), dayWorkTimes), cafe);
        assertNotNull(workTime.getCafe());
    }
}
