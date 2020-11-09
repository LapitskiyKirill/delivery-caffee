package com.gmail.kirilllapitsky.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gmail.kirilllapitsky.entity.Description;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@RequiredArgsConstructor
public class ItemDto {
    private Long id;

    private Description description;

    private Integer cost;

    private Integer discount;

    private List<FeedbackDto> feedbackDto;
}
