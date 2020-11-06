package com.gmail.kirilllapitsky.controller;

import com.gmail.kirilllapitsky.dto.SpecialOfferDto;
import com.gmail.kirilllapitsky.service.SpecialOfferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("specialOffer")
public class OfferController {
    private final SpecialOfferService specialOfferItemsService;

    public OfferController(SpecialOfferService specialOfferItemsService) {
        this.specialOfferItemsService = specialOfferItemsService;
    }

    @GetMapping("get")
    SpecialOfferDto get(@RequestParam Long id) {
        return specialOfferItemsService.findSpecialOfferItemsById(id);
    }

}
