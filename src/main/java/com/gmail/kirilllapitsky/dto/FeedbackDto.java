package com.gmail.kirilllapitsky.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gmail.kirilllapitsky.entity.User;
import lombok.Data;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class FeedbackDto {
    public Long id;

    public User user;

    public String review;

    public FeedbackDto() {
    }

    public FeedbackDto(Long id, User user, String review) {
        this.id = id;
        this.user = user;
        this.review = review;
    }
}
