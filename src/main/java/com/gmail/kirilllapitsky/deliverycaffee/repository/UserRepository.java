package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Optional<User> findById(Long id);

    Optional<User> findByLoginAndCafe(String login, Cafe cafe);

    List<User> findAllByCafe(Cafe cafe, Pageable pageable);

    List<User> findAllByRole(Role role, Pageable pageable);

    List<User> findAllByRoleAndCafe(Role role, Cafe cafe, Pageable pageable);
}
