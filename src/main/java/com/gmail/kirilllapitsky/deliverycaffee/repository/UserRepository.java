package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.Cafe;
import com.gmail.kirilllapitsky.deliverycaffee.entity.User;
import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Role;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);

    Optional<User> findById(Long id);

    @Query(value = "SELECT u FROM User u where " +
            "(:login is null or u.login = :login) " +
            "and (:role is null or u.role = :role) " +
            "and (:cafe is null or u.cafe = :cafe)")
    List<User> findUserByRoleAndCafeAndLogin(@Param("login") String login, @Param("role") Role role, @Param("cafe") Cafe cafe, Pageable pageable);
}
