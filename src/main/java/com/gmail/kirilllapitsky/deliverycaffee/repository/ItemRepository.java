package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<Item> findById(Long id);
}
