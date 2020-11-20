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

import java.util.List;
import java.util.stream.Collectors;

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
        User user = TestData.getUser(Role.CUSTOMER);
        userRepository.save(user);
        userService.setRole(user.getId(), Role.MANAGER);
        User testUser = userRepository.findById(user.getId()).orElseThrow();
        assertEquals(Role.MANAGER, testUser.getRole());
    }

    @Test
    public void changeUserCafe_whenSaveAndRetrieveEntity_thenOK() {
        User user = TestData.getUser(Role.CUSTOMER);
        Cafe cafe = TestData.getCafe();
        cafeRepository.save(cafe);
        userRepository.save(user);
        userService.setCafe(user.getId(), cafe.getId());
        User testUser = userRepository.findById(user.getId()).orElseThrow();
        assertEquals(cafe.getId(), testUser.getCafe().getId());
    }

    @Test
    public void shouldFindUserByLogin() {
        User user = TestData.getUser(Role.CUSTOMER);
        userRepository.save(user);
        UserDto userDto = Mapper.map(user, UserDto.class);
        UserDto testUser = userService.findByLogin(user.getLogin());
        assertEquals(userDto, testUser);
    }

    @Test
    public void shouldFindUsersByCafe() {
        Cafe cafe = TestData.getCafe();
        cafeRepository.save(cafe);
        List<User> users = TestData.getListOfUsers();
        users.get(0).setCafe(cafe);
        userRepository.saveAll(users);
        List<UserDto> userDto = userService.findByCafe(cafe.getId());
        List<UserDto> testUserDto = Mapper.mapList(
                users
                        .stream()
                        .filter(u -> u.getCafe() != null)
                        .collect(Collectors.toList()),
                UserDto.class);
        assertEquals(userDto, testUserDto);
    }
}