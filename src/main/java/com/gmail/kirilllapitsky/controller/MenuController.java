package com.gmail.kirilllapitsky.controller;

import com.gmail.kirilllapitsky.dto.MenuDto;
import com.gmail.kirilllapitsky.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("get")
    MenuDto get(@RequestParam Long id) {
        return  menuService.findById(id);
    }
}
