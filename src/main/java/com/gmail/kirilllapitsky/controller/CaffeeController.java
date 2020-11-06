package com.gmail.kirilllapitsky.controller;

import com.gmail.kirilllapitsky.dto.CaffeeDto;
import com.gmail.kirilllapitsky.service.CaffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("caffee")
public class CaffeeController {
    private final CaffeeService caffeeService;

    public CaffeeController(CaffeeService caffeeService) {
        this.caffeeService = caffeeService;
    }

    @GetMapping("get")
    CaffeeDto get(@RequestParam Long id) {
        return caffeeService.findById(id);
    }
}
