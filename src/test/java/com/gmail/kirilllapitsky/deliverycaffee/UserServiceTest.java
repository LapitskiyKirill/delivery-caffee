package com.gmail.kirilllapitsky.deliverycaffee;

import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;


public class UserServiceTest extends ServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void changeUserRole_whenSaveAndRetreiveEntity_thenOK() {
        User user = new User("login", "password", Role.CLIENT, null);
        userRepository.save(user);
        userService.setRole(user.getId(), Role.MANAGER);
        assertEquals(Role.MANAGER, userRepository.findById(user.getId()).orElseThrow().getRole());
    }
}