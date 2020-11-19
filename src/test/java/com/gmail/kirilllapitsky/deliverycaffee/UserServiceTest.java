package com.gmail.kirilllapitsky.deliverycaffee;

import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void changeUserRole_whenSaveAndRetreiveEntity_thenOK() {
        User user = new User("login", "password", Role.CUSTOMER, null);
        userRepository.save(user);
        userService.setRole(user.getId(), Role.MANAGER);
        assertEquals(Role.MANAGER, userRepository.findById(user.getId()).orElseThrow().getRole());
    }
}