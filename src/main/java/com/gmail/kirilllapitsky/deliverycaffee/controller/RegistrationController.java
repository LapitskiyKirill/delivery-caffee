package com.gmail.kirilllapitsky.deliverycaffee.controller;

import com.gmail.kirilllapitsky.deliverycaffee.dto.RegisterUserDto;
import com.gmail.kirilllapitsky.deliverycaffee.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public void userRegistration(@RequestBody RegisterUserDto userDto) {
        registrationService.create(userDto);
    }
}
