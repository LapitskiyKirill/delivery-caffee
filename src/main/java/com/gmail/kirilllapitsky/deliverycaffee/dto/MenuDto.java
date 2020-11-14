package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    private Long id;

    private List<ItemDto> menuItems;

    private List<SpecialOfferDto> specialOffers;
}
