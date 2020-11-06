package com.gmail.kirilllapitsky.repository;

import com.gmail.kirilllapitsky.entity.Caffee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CaffeeRepository extends CrudRepository<Caffee, Long> {
    Optional<Caffee> findById(Long id);
}
