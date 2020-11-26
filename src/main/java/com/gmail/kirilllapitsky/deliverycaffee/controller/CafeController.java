package com.gmail.kirilllapitsky.deliverycaffee.controller;

import com.gmail.kirilllapitsky.deliverycaffee.dto.CafeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.EditCafeDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewCafeDto;
import com.gmail.kirilllapitsky.deliverycaffee.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("findById")
    public CafeDto find(@RequestParam Long id) {
        return cafeService.find(id);
    }

    @PostMapping("create")
    public void create(@Valid @RequestBody NewCafeDto newCafeDto) {
        cafeService.create(newCafeDto);
    }
}
