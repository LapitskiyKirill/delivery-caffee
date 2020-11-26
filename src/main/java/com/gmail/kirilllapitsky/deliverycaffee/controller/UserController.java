package com.gmail.kirilllapitsky.deliverycaffee.controller;

import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("updateRole")
    public void updateRole(@RequestParam Long id, @RequestParam Role role) {
        userService.updateRole(id, role);
    }

    @GetMapping("findByLogin")
    public UserDto find(@RequestParam String login) {
        return userService.find(login, Optional.empty());
    }

    @GetMapping("findByLoginAndCafe")
    public UserDto find(@RequestParam String login, @RequestParam Long cafeId) {
        return userService.find(login, Optional.of(cafeId));
    }


    @GetMapping("findByCafe")
    public List<UserDto> find(@RequestParam Long cafeId,
                              @RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "3") int size) {
        Pageable paging = PageRequest.of(page, size);
        return userService.findByCafe(cafeId, paging);
    }

}
