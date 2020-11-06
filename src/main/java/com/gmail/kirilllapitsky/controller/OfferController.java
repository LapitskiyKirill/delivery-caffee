package com.gmail.kirilllapitsky.controller;

import com.gmail.kirilllapitsky.dto.SpecialOfferDto;
import com.gmail.kirilllapitsky.service.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("specialOffer")
public class OfferController {
    @Autowired
    private SpecialOfferService specialOfferItemsService;

    @GetMapping("get")
    SpecialOfferDto get(@RequestParam Long id) {
        return specialOfferItemsService.findSpecialOfferItemsById(id);
    }

}
