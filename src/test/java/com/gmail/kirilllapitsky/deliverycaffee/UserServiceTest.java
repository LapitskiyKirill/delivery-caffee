package com.gmail.kirilllapitsky.deliverycaffee;

import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.service.UserService;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class UserServiceTest extends ServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CafeRepository cafeRepository;

    @Autowired
    private UserService userService;

    @Test
    public void changeUserRole_whenSaveAndRetrieveEntity_thenOK() {
        User user = new User("login", "password", Role.CLIENT, null);
        userRepository.save(user);
        userService.setRole(user.getId(), Role.MANAGER);
        assertEquals(Role.MANAGER, userRepository.findById(user.getId()).orElseThrow().getRole());
    }

    @Test
    public void changeUserCafe_whenSaveAndRetrieveEntity_thenOK() {
        User user = new User("login", "password", Role.CLIENT, null);
        Cafe cafe = new Cafe("name", "address", "worktime");
        cafeRepository.save(cafe);
        userRepository.save(user);
        userService.setCafe(user.getId(), cafe.getId());
        assertEquals(cafe.getId(), userRepository.findById(user.getId()).orElseThrow().getCafe().getId());
    }

    @Test
    public void shouldFindUserByLogin() {
        User user = new User("login", "password", Role.CLIENT, null);
        userRepository.save(user);
        assertEquals(Mapper.map(user, UserDto.class), userService.findByLogin(user.getLogin()));
    }

    @Test
    public void shouldFindUsersByCafe() {
        Cafe cafe = new Cafe("name", "address", "worktime");
        cafeRepository.save(cafe);
        User user1 = new User("login1", "password1", Role.MANAGER, cafe);
        User user2 = new User("login2", "password2", Role.MANAGER, cafe);
        User user3 = new User("login3", "password3", Role.CLIENT, null);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        List<User> cafeManagers = new ArrayList<>();
        cafeManagers.add(user1);
        cafeManagers.add(user2);
        assertEquals(userService.findByCafe(cafe.getId()), Mapper.mapList(cafeManagers, UserDto.class));
    }
}