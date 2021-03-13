package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.validation.WorkerTypeValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewWorkerDto {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotNull
    @WorkerTypeValidator
    private Role role;
    @Email
    private String email;
    @NotNull
    private Long cafeId;
}
