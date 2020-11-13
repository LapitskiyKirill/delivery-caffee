package com.gmail.kirilllapitsky.controller;

import com.gmail.kirilllapitsky.dto.MenuDto;
import com.gmail.kirilllapitsky.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
@AllArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("findById")
    MenuDto find(@RequestParam Long id) {
        return  menuService.find(id);
    }
}
