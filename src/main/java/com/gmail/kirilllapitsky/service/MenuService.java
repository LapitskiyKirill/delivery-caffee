package com.gmail.kirilllapitsky.service;

import com.gmail.kirilllapitsky.dto.MenuDto;
import com.gmail.kirilllapitsky.repository.*;
import com.gmail.kirilllapitsky.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuDto find(Long id) {
        return Mapper.map(menuRepository.findById(id).get(), MenuDto.class);
    }

}
