package com.gmail.kirilllapitsky.deliverycaffee.ServiceTest;

import com.gmail.kirilllapitsky.deliverycaffee.ServiceTest.ServiceTest;
import com.gmail.kirilllapitsky.deliverycaffee.TestData;
import com.gmail.kirilllapitsky.deliverycaffee.dto.DayWorkTimeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkTimeDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.WorkTime;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.service.WorkTimeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WorkTimeServiceTest extends ServiceTest {

    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    private WorkTimeService workTimeService;

    private Cafe cafe;

    @Before
    public void setUp() {
        cafe = TestData.getCafe();
        cafeRepository.save(cafe);
    }

    @Test
    public void shouldSaveNewWorkTime() {
        List<DayWorkTimeDto> dayWorkTimes = TestData.getDayWorkTimeDto();

        WorkTime workTime = workTimeService.save(new NewWorkTimeDto(cafe.getId(), dayWorkTimes), cafe);

        assertEquals(workTime.getDayWorkTimes().size(), 4);
    }

    @Test
    public void shouldHaveCafe() {
        List<DayWorkTimeDto> dayWorkTimes = TestData.getDayWorkTimeDto();

        WorkTime workTime = workTimeService.save(new NewWorkTimeDto(cafe.getId(), dayWorkTimes), cafe);

        assertNotNull(workTime.getCafe());
    }
}
