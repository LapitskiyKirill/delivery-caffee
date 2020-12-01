package com.gmail.kirilllapitsky.deliverycaffee.ServiceTest;

import com.gmail.kirilllapitsky.deliverycaffee.TestData;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkerDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoPermissionException;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoSuchEntityException;
import com.gmail.kirilllapitsky.deliverycaffee.filter.UserFilterSettings;
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
    private User manager;
    private User administrator;
    private Cafe cafe;
    private UserFilterSettings userFilterSettings;
    private NewWorkerDto newWorkerDto;
    private List<User> users;

    @Before
    public void setUp() {
        user = TestData.getUser(Role.CUSTOMER);
        manager = TestData.getUser(Role.MANAGER);
        administrator = TestData.getUser(Role.ADMINISTRATOR);
        userRepository.save(user);
        userRepository.save(administrator);
        cafe = TestData.getCafe();
        cafeRepository.save(cafe);
        manager.setCafe(cafe);
        userRepository.save(manager);
        users = TestData.getListOfUsers();
        users.get(0).setCafe(cafe);
        userRepository.saveAll(users);
        cafeRepository.save(cafe);
        newWorkerDto = TestData.getNewWorkerDto(cafe.getId());
        userFilterSettings = TestData.getUserFilterSettings(cafe);
    }

    @Test
    public void shouldUpdateRole() {

        userService.updateRole(user.getId(), Role.MANAGER);
        User testUser = userRepository.findById(user.getId()).orElseThrow();

        assertEquals(Role.MANAGER, testUser.getRole());
    }

    @Test
    public void shouldFindUserByLogin() throws NoPermissionException, NoSuchEntityException {
        UserDto userDto = Mapper.map(user, UserDto.class);
        UserDto testUser = userService.find(manager, user.getLogin(), Optional.empty());

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

    @Test
    public void shouldFindUsersByFilter() throws NoPermissionException, NoSuchEntityException {
        List<UserDto> users = userService.findFiltered(administrator, userFilterSettings, PageRequest.of(0, 3));

        assertEquals(users.size(), 2);
    }

    @Test
    public void shouldCreateWorker() throws Exception {
        UserDto userDto = userService.create(newWorkerDto, manager);

        assertEquals(userDto.getCafe().getId(), manager.getCafe().getId());
        assertEquals(userDto.getLogin(), newWorkerDto.getLogin());
        assertEquals(userDto.getRole(), newWorkerDto.getRole());
    }
}