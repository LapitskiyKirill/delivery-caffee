package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CafeRepository extends CrudRepository<Cafe, Long> {
    Optional<Cafe> findById(Long id);

    Optional<Cafe> findByName(String name);
}
