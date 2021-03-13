package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewWorkTimeDto {
    @NotNull
    private Long cafeId;

    @NotNull
    private List<DayWorkTimeDto> dayWorkTimes;
}
