package com.gmail.kirilllapitsky.deliverycaffee.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterCustomerDto {
    @NotBlank
    private String login;

    @NotBlank
    private String password;
}
