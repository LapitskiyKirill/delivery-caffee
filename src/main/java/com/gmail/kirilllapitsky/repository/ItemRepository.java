package com.gmail.kirilllapitsky.repository;

import com.gmail.kirilllapitsky.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<Item> findById(Long id);
}
