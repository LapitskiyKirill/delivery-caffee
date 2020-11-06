package com.gmail.kirilllapitsky.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class CaffeeDto {
    public Long id;

    public String name;

    public String address;

    public String workTime;

    public List<UserDto> users;

    public CaffeeDto() {
    }

    public CaffeeDto(Long id, String name, String address, String workTime, List<UserDto> userIds) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.workTime = workTime;
        this.users = userIds;
    }
}
