package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Description;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@RequiredArgsConstructor
public class SpecialOfferDto {
    private Long id;

    private Description description;

    private Integer cost;

    private List<ItemDto> specialOfferItems;
}
