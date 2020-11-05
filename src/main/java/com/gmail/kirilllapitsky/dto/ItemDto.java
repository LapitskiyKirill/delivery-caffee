package com.gmail.kirilllapitsky.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gmail.kirilllapitsky.entity.Description;
import lombok.Data;

import java.util.List;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class ItemDto {
    private Long id;

    private Description description;

    private int cost;

    private int discount;

    private List<FeedbackDto> feedbackDto;
}
