package com.gmail.kirilllapitsky.deliverycaffee.ServiceTest;

import com.gmail.kirilllapitsky.deliverycaffee.TestData;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.service.UserService;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class UserServiceTest extends ServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CafeRepository cafeRepository;

    @Autowired
    private UserService userService;

    private User user;
    private Cafe cafe;
    private List<User> users;

    @Before
    public void setUp() {
        user = TestData.getUser(Role.CUSTOMER);
        userRepository.save(user);
        cafe = TestData.getCafe();
        cafeRepository.save(cafe);
        setUpUsers();
    }

    public void setUpUsers() {
        users = TestData.getListOfUsers();
        users.get(0).setCafe(cafe);
        userRepository.saveAll(users);
    }

    @Test
    public void changeUserRole_whenSaveAndRetrieveEntity_thenOK() {
        userService.updateRole(user.getId(), Role.MANAGER);
        User testUser = userRepository.findById(user.getId()).orElseThrow();
        assertEquals(Role.MANAGER, testUser.getRole());
    }

    @Test
    public void shouldFindUserByLogin() {
        UserDto userDto = Mapper.map(user, UserDto.class);
        UserDto testUser = userService.find(user.getLogin(), Optional.empty());
        assertEquals(userDto, testUser);
    }

    @Test
    public void shouldFindUsersByCafe() {
        List<UserDto> userDto = userService.findByCafe(cafe.getId(), PageRequest.of(0, 5));
        List<UserDto> testUserDto = Mapper.mapList(
                users
                        .stream()
                        .filter(u -> u.getCafe() != null)
                        .collect(Collectors.toList()),
                UserDto.class);
        assertEquals(userDto, testUserDto);
    }
}