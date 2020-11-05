package com.gmail.kirilllapitsky.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gmail.kirilllapitsky.entity.SpecialOffer;
import lombok.Data;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class MenuDto {
    public Long id;

    public List<ItemDto> items;

    public List<SpecialOffer> specialOffers;

    public MenuDto() {
    }

    public MenuDto(Long id, List<ItemDto> items, List<SpecialOffer> specialOffers) {
        this.id = id;
        this.items = items;
        this.specialOffers = specialOffers;
    }
}
