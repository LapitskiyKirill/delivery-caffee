package com.gmail.kirilllapitsky.repository;

import com.gmail.kirilllapitsky.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedBackRepository extends CrudRepository<Feedback, Long> {
    List<Feedback> findAllByItemId(Long itemId);
}
