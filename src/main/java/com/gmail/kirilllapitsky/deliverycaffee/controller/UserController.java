package com.gmail.kirilllapitsky.deliverycaffee.controller;

import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkerDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoPermissionException;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoSuchEntityException;
import com.gmail.kirilllapitsky.deliverycaffee.filter.UserFilterSettings;
import com.gmail.kirilllapitsky.deliverycaffee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public UserDto find(@ModelAttribute User user,
                        @RequestHeader("Authorization") String token,
                        @RequestParam String login) throws NoPermissionException, NoSuchEntityException {
        return userService.find(user, login, Optional.empty());
    }

    @GetMapping("findByLoginAndCafe")
    public UserDto find(@ModelAttribute User user,
                        @RequestHeader("Authorization") String token,
                        @RequestParam String login,
                        @RequestParam Long cafeId) throws NoPermissionException, NoSuchEntityException {
        return userService.find(user, login, Optional.of(cafeId));
    }

    @GetMapping("findByCafe")
    public List<UserDto> find(@RequestParam Long cafeId,
                              @RequestBody Pageable pageable) {
        return userService.findByCafe(cafeId, pageable);
    }

    @GetMapping("findByFilter")
    public List<UserDto> findFiltered(@ModelAttribute User user,
                                      @RequestHeader("Authorization") String token,
                                      @RequestBody UserFilterSettings userFilterSettings,
                                      @RequestBody Pageable pageable) throws NoPermissionException, NoSuchEntityException {
        return userService.findFiltered(user, userFilterSettings, pageable);
    }

    @GetMapping("create")
    public UserDto create(@ModelAttribute User user,
                          @RequestHeader("Authorization") String token,
                          @Valid @RequestBody NewWorkerDto newWorkerDto) throws Exception {
        return userService.create(newWorkerDto, user);
    }
}
