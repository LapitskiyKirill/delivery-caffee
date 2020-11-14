package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@RequiredArgsConstructor
public class CaffeeDto {
    private Long id;

    private String name;

    private String address;

    private String workTime;

    private List<UserDto> users;
}
