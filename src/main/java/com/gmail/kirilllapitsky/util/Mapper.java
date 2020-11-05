package com.gmail.kirilllapitsky.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;

public class Mapper {
    static ModelMapper mapper = new ModelMapper();

    public static <T> T map(Object element, Class<T> classType) {
        return mapper.map(element, classType);
    }

    public static <T> List<T> mapList(Collection<?> list, Class<T> classType) {
        return list.stream()
                .map(o -> map(o, classType))
                .collect(Collectors.toList());
    }
}
