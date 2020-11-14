package com.gmail.kirilllapitsky.service;

import com.gmail.kirilllapitsky.dto.MenuDto;
import com.gmail.kirilllapitsky.repository.MenuRepository;
import com.gmail.kirilllapitsky.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuDto find(Long id) {
        return Mapper.map(menuRepository.findById(id).get(), MenuDto.class);
    }

}
