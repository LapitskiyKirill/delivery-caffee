package com.gmail.kirilllapitsky.deliverycaffee.ServiceTest;

import com.gmail.kirilllapitsky.deliverycaffee.TestData;
import com.gmail.kirilllapitsky.deliverycaffee.dto.EditWorkerDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.NewWorkerDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserDto;
import com.gmail.kirilllapitsky.deliverycaffee.dto.UserFilterSettings;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.exception.NoSuchEntityException;
import com.gmail.kirilllapitsky.deliverycaffee.repository.CafeRepository;
import com.gmail.kirilllapitsky.deliverycaffee.repository.UserRepository;
import com.gmail.kirilllapitsky.deliverycaffee.service.UserService;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


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
    private EditWorkerDto editWorkerDto;


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
        userFilterSettings = TestData.getUserFilterSettings();
        editWorkerDto = TestData.getEditWorkerDto(manager);
    }

    @Test
    public void shouldUpdateRole() {
        userService.updateRole(user.getId(), Role.MANAGER);
        User testUser = userRepository.findById(user.getId()).orElseThrow();

        assertEquals(Role.MANAGER, testUser.getRole());
    }

    @Test
    public void shouldFindUsersByCafe() {
        List<UserDto> testUserDto = Mapper.mapList(
                users
                        .stream()
                        .filter(u -> u.getCafe() != null)
                        .collect(Collectors.toList()),
                UserDto.class);

        assertTrue(testUserDto.size() > 0);
    }

    @Test
    public void shouldFindUsersByCafeFilter() throws NoSuchEntityException {
        userFilterSettings.setCafeId(cafe.getId());
        userFilterSettings.setLogin(null);
        userFilterSettings.setRole(null);

        List<UserDto> users = userService.find(userFilterSettings, PageRequest.of(0, 3));

        assertEquals(users.size(), 2);
    }

    @Test
    public void shouldFindUsersByLoginAndCafeFilter() throws NoSuchEntityException {
        userFilterSettings.setCafeId(cafe.getId());
        userFilterSettings.setLogin("login1");
        userFilterSettings.setRole(null);

        List<UserDto> users = userService.find(userFilterSettings, PageRequest.of(0, 3));

        assertEquals(users.size(), 1);
    }

    @Test
    public void shouldFindUsersByLoginFilter() throws NoSuchEntityException {
        userFilterSettings.setCafeId(null);
        userFilterSettings.setLogin("login1");
        userFilterSettings.setRole(null);

        List<UserDto> users = userService.find(userFilterSettings, PageRequest.of(0, 3));

        assertEquals(users.size(), 1);
    }

    @Test
    public void shouldFindUsersByRoleFilter() throws NoSuchEntityException {
        userFilterSettings.setCafeId(null);
        userFilterSettings.setLogin(null);
        userFilterSettings.setRole(Role.CUSTOMER);

        List<UserDto> users = userService.find(userFilterSettings, PageRequest.of(0, 3));

        assertEquals(users.size(), 1);
    }

    @Test
    public void shouldCreateWorkerByManager() throws Exception {
        UserDto userDto = userService.create(manager, newWorkerDto);

        assertEquals(userDto.getCafe().getId(), manager.getCafe().getId());
        assertEquals(userDto.getLogin(), newWorkerDto.getLogin());
        assertEquals(userDto.getRole(), newWorkerDto.getRole());
    }

    @Test
    public void shouldCreateManagerAdministrator() throws Exception {
        newWorkerDto.setRole(Role.MANAGER);

        UserDto userDto = userService.create(administrator, newWorkerDto);

        assertEquals(userDto.getCafe().getId(), newWorkerDto.getCafeId());
        assertEquals(userDto.getLogin(), newWorkerDto.getLogin());
        assertEquals(userDto.getRole(), Role.MANAGER);
    }

    @Test
    public void shouldDeleteWorker() throws Exception {
        userFilterSettings.setLogin(user.getLogin());

        userService.delete(user.getId());
        List<UserDto> foundUsers = userService.find(userFilterSettings, PageRequest.of(0, 3));

        assertEquals(0, foundUsers.size());
    }

    @Test
    public void shouldEditWorker() throws Exception {
        editWorkerDto.setRole(Role.COOKER);

        UserDto editedWorker = userService.edit(editWorkerDto);

        assertEquals(Role.COOKER, editedWorker.getRole());
    }
}