package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@RequiredArgsConstructor
public class NewCaffeeDto {
    private String name;

    private String address;

    private String workTime;
}
