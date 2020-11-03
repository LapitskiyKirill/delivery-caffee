package com.gmail.kirilllapitsky.repository;

import com.gmail.kirilllapitsky.entity.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {
    Optional<Token> findById(Long id);
}
