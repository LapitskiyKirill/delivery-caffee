package com.gmail.kirilllapitsky.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gmail.kirilllapitsky.entity.Description;
import lombok.Data;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class SpecialOfferDto {
    public Long id;

    public Description description;

    public Integer cost;

    public List<ItemDto> items;

    public SpecialOfferDto() {
    }

    public SpecialOfferDto(Long id, Description description, int cost, List<ItemDto> items) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.items = items;
    }
}
