package com.gmail.kirilllapitsky.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gmail.kirilllapitsky.enumerable.Role;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class UserDto {
    public Long id;

    public String login;

    public Role role;

    public Long caffeeId;

    public UserDto() {
    }

    public UserDto(Long id, String login, Role role, Long caffeeId) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.caffeeId = caffeeId;
    }
}
