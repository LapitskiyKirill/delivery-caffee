package com.gmail.kirilllapitsky.deliverycaffee.controller;

import com.gmail.kirilllapitsky.deliverycaffee.dto.RegisterCustomerDto;
import com.gmail.kirilllapitsky.deliverycaffee.exception.RegistrationException;
import com.gmail.kirilllapitsky.deliverycaffee.service.RegistrationCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationCustomerService registrationCustomerService;

    @PostMapping
    public void userRegistration(@Valid @RequestBody RegisterCustomerDto userDto) throws RegistrationException {
        registrationCustomerService.create(userDto);
    }
}
