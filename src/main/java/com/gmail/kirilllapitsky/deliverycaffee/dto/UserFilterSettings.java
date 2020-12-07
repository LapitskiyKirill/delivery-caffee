package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.validation.FilterWorkerTypeValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFilterSettings {
    private String login;
    private Long cafeId;
    @FilterWorkerTypeValidator
    private Role role;
}
