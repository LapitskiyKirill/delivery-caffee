package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.Caffee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CaffeeRepository extends CrudRepository<Caffee, Long> {
    Optional<Caffee> findById(Long id);
}
