package com.gmail.kirilllapitsky.service;

import com.gmail.kirilllapitsky.dto.SpecialOfferDto;
import com.gmail.kirilllapitsky.repository.SpecialOfferRepository;
import com.gmail.kirilllapitsky.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialOfferService {
    private final SpecialOfferRepository specialOfferRepository;

    public SpecialOfferDto find(Long id) {
        return Mapper.map(specialOfferRepository.findById(id).orElseThrow(), SpecialOfferDto.class);
    }
}