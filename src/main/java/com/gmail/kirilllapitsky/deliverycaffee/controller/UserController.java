package com.gmail.kirilllapitsky.deliverycaffee.controller;

import com.gmail.kirilllapitsky.deliverycaffee.dto.EditWorkerDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkerDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserFilterSettings;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoSuchEntityException;
import com.gmail.kirilllapitsky.deliverycaffee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("updateRole")
    public void updateRole(@RequestParam Long id, @RequestParam Role role) {
        userService.updateRole(id, role);
    }

    @PreAuthorize("hasAnyRole('Role.ADMINISTRATOR', 'Role.MANAGER')")
    @GetMapping("find")
    public List<UserDto> find(@ModelAttribute User user,
                              @RequestBody UserFilterSettings userFilterSettings,
                              @RequestBody Pageable pageable) throws NoSuchEntityException {
        return userService.find(userFilterSettings, pageable);
    }

    @GetMapping("create")
    @PreAuthorize("hasRole('Role.ADMINISTRATOR')")
    public UserDto create(@ModelAttribute User user,
                          @Valid @RequestBody NewWorkerDto newWorkerDto) throws Exception {
        return userService.create(user, newWorkerDto);
    }

    @GetMapping("edit")
    @PreAuthorize("hasRole('Role.ADMINISTRATOR')")
    public UserDto edit(@ModelAttribute User user,
                        @Valid @RequestBody EditWorkerDto editWorkerDto) throws Exception {
        return userService.edit(editWorkerDto);
    }

    @GetMapping("delete")
    @PreAuthorize("hasRole('Role.ADMINISTRATOR')")
    public void delete(@ModelAttribute User user,
                       @RequestParam Long userId) throws Exception {
        userService.delete(userId);
    }
}
