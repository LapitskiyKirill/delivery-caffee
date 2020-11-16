package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import lombok.Data;

@Data
public class RegisterUserDto {
    private String login;

    private String password;

    private Role role;
}


