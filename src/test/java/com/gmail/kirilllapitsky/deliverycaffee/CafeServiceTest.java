package com.gmail.kirilllapitsky.deliverycaffee;

import com.gmail.kirilllapitsky.deliverycaffee.dto.NewCafeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkTimeDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.service.CafeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class CafeServiceTest extends ServiceTest {
    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    private CafeService cafeService;

    @Test
    public void shouldSaveCafe() {
        NewCafeDto newCafeDto = TestData.getNewCafeDto();
        newCafeDto.setName("name12");
        cafeService.create(newCafeDto);
        Cafe cafe = cafeRepository.findByName(newCafeDto.getName()).orElseThrow();
        assertEquals(cafe.getName(), newCafeDto.getName());
        assertEquals(cafe.getAddress(), newCafeDto.getAddress());
    }

    @Test
    public void shouldSetWorkTime() {
        NewCafeDto newCafeDto = TestData.getNewCafeDto();
        cafeService.create(newCafeDto);
        Cafe cafe = cafeRepository.findByName(newCafeDto.getName()).orElseThrow();
        NewWorkTimeDto newWorkTimeDto = TestData.getNewWorkTimeDto(cafe.getId());
        cafeService.setWorkTime(newWorkTimeDto);
        cafe = cafeRepository.findByName(newCafeDto.getName()).orElseThrow();
        assertEquals(cafe.getWorkTime().getDayWorkTimes().size(), 4);
    }
}
