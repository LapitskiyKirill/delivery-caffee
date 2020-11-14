package com.gmail.kirilllapitsky.deliverycaffee.controller;

import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("setRole")
    public void setRole(@RequestParam Long id, @RequestParam Role role) {
        userService.setRole(id, role);
    }

    @PostMapping("setCaffee")
    public void setCaffee(@RequestParam Long userId, @RequestParam Long caffeeId) {
        userService.setCaffee(userId, caffeeId);
    }

    @GetMapping("findByLogin")
    public UserDto find(@RequestParam String login) {
        return userService.findByLogin(login);
    }

    @GetMapping("findByCaffee")
    public List<UserDto> find(@RequestParam Long caffeeId) {
        return userService.findByCaffee(caffeeId);
    }

}
