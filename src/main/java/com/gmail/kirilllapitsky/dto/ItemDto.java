package com.gmail.kirilllapitsky.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gmail.kirilllapitsky.entity.Description;
import lombok.Data;

import java.util.List;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class ItemDto {
    public Long id;

    public Description description;

    public Integer cost;

    public Integer discount;

    public List<FeedbackDto> feedbackDto;

    public ItemDto() {
    }

    public ItemDto(Long id, Description description, int cost, int discount, List<FeedbackDto> feedbackDto) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.discount = discount;
        this.feedbackDto = feedbackDto;
    }
}
