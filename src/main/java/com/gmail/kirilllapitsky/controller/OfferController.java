package com.gmail.kirilllapitsky.controller;

import com.gmail.kirilllapitsky.dto.SpecialOfferDto;
import com.gmail.kirilllapitsky.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {
    @Autowired
    private SpecialOfferService specialOfferItemsService;

    @GetMapping("get")
    SpecialOfferDto get(@RequestParam Long id) {
        return specialOfferItemsService.findSpecialOfferItemsById(id);
    }

}
