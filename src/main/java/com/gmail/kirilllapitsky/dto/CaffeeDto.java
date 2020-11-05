package com.gmail.kirilllapitsky.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class CaffeeDto {
    private Long id;

    private String name;

    private String address;

    private String workTime;

    private List<Long> userIds;
}
