package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.MenuDto;
import com.gmail.kirilllapitsky.deliverycaffee.repository.MenuRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
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
