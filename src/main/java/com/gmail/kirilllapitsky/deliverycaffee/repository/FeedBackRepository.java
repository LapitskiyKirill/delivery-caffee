package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedBackRepository extends CrudRepository<Feedback, Long> {
    List<Feedback> findAllByItemId(Long itemId);
}
