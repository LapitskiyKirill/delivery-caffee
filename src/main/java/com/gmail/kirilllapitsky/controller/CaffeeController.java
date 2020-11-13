package com.gmail.kirilllapitsky.controller;

import com.gmail.kirilllapitsky.dto.CaffeeDto;
import com.gmail.kirilllapitsky.dto.EditCaffeeDto;
import com.gmail.kirilllapitsky.dto.NewCaffeeDto;
import com.gmail.kirilllapitsky.service.CaffeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("caffee")
@AllArgsConstructor
public class CaffeeController {
    private final CaffeeService caffeeService;

    @GetMapping("findById")
    public CaffeeDto find(@RequestParam Long id) {
        return caffeeService.find(id);
    }

    @PostMapping("create")
    public void create(@RequestBody NewCaffeeDto newCaffeeDto) {
        caffeeService.create(newCaffeeDto);
    }

    @PostMapping("edit")
    public void edit(@RequestBody EditCaffeeDto editCaffeeDto) {
        caffeeService.edit(editCaffeeDto);
    }
}
