package com.gmail.kirilllapitsky;

import com.gmail.kirilllapitsky.entity.User;
import com.gmail.kirilllapitsky.enumerable.Role;
import com.gmail.kirilllapitsky.repository.UserRepository;
import com.gmail.kirilllapitsky.service.UserService;
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
        User user = new User("login", "password", Role.CLIENT, null);
        userRepository.save(user);
        userService.setRole(user.getId(), Role.MANAGER);
        assertEquals(Role.MANAGER, userRepository.findById(user.getId()).orElseThrow().getRole());
    }
}