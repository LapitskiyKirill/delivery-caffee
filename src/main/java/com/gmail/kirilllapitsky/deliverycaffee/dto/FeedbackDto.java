package com.gmail.kirilllapitsky.deliverycaffee.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {
    private Long id;

    private UserDto user;

    private String review;
}
