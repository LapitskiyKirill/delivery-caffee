package com.gmail.kirilllapitsky.deliverycaffee;

import com.gmail.kirilllapitsky.deliverycaffee.dto.*;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Days;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestData {
    public static Cafe getCafe() {
        return new Cafe("name", "address", null, Collections.emptyList());
    }

    public static List<DayWorkTimeDto> getDayWorkTimeDto() {
        return Arrays.asList(
                new DayWorkTimeDto(Days.MONDAY, LocalTime.of(12, 0, 0), LocalTime.of(23, 0, 0), false),
                new DayWorkTimeDto(Days.TUESDAY, LocalTime.of(12, 0, 0), LocalTime.of(23, 0, 0), false),
                new DayWorkTimeDto(Days.WEDNESDAY, LocalTime.of(12, 0, 0), LocalTime.of(23, 0, 0), false),
                new DayWorkTimeDto(Days.THURSDAY, LocalTime.of(12, 0, 0), LocalTime.of(23, 0, 0), false)
        );
    }

    public static NewWorkTimeDto getNewWorkTimeDto(Long cafeId) {
        return new NewWorkTimeDto(cafeId, TestData.getDayWorkTimeDto());
    }

    public static NewCafeDto getNewCafeDto() {
        return new NewCafeDto("name", "address");
    }

    public static User getUser(Role role) {
        return new User("login" + role, "password", role, null);
    }

    public static List<User> getListOfUsers() {
        return Arrays.asList(
                new User("login1", "password1", Role.MANAGER, null),
                new User("login2", "password2", Role.MANAGER, null)
        );
    }

    public static NewWorkerDto getNewWorkerDto(Long cafeId) {
        return new NewWorkerDto("workerLogin", "password", Role.COOKER, "email", cafeId);
    }

    public static UserFilterSettings getUserFilterSettings() {
        return new UserFilterSettings(null, null, null);
    }

    public static EditWorkerDto getEditWorkerDto(User user) {
        EditWorkerDto editWorkerDto = Mapper.map(user, EditWorkerDto.class);
        editWorkerDto.setCafeId(user.getCafe().getId());
        return editWorkerDto;
    }
}