package com.gmail.kirilllapitsky.repository;

import com.gmail.kirilllapitsky.entity.Caffee;
import com.gmail.kirilllapitsky.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Optional<User> findById(Long id);

    List<User> findAllByCaffee(Caffee caffee);
}
