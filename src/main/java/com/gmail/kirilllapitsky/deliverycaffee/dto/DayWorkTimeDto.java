package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Days;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayWorkTimeDto {
    private Days day;

    private LocalTime openTime;

    private LocalTime closeTime;

    private Boolean isDayOff;
}
