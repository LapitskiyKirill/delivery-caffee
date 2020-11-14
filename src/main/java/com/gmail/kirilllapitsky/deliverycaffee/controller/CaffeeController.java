package com.gmail.kirilllapitsky.deliverycaffee.controller;

import com.gmail.kirilllapitsky.deliverycaffee.dto.CaffeeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.EditCaffeeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewCaffeeDto;
import com.gmail.kirilllapitsky.deliverycaffee.service.CaffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("caffee")
@RequiredArgsConstructor
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
