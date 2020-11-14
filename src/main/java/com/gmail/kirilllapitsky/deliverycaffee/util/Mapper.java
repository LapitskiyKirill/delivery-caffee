package com.gmail.kirilllapitsky.deliverycaffee.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;

public class Mapper {
    public static ModelMapper mapper;

    static {
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(false)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
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
