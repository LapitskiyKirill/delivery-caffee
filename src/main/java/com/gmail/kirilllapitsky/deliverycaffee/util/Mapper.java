package com.gmail.kirilllapitsky.deliverycaffee.util;

import com.gmail.kirilllapitsky.deliverycaffee.dto.RegisterCustomerDto;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(false)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.typeMap(RegisterCustomerDto.class, User.class).addMappings(mapper ->
                mapper.map(__ -> Role.CUSTOMER, User::setRole)
        );
    }

    public static <T> T map(Object element, Class<T> classType) {
        return mapper.map(element, classType);
    }

    public static <T> List<T> mapList(Collection<?> list, Class<T> classType) {
        return list.stream()
                .map(o -> map(o, classType))
                .collect(Collectors.toList());
    }
}
