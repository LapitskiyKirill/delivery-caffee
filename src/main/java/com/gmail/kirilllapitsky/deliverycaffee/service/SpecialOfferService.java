package com.gmail.kirilllapitsky.deliverycaffee.service;

import com.gmail.kirilllapitsky.deliverycaffee.dto.SpecialOfferDto;
import com.gmail.kirilllapitsky.deliverycaffee.repository.SpecialOfferRepository;
import com.gmail.kirilllapitsky.deliverycaffee.util.Mapper;
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