package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.Caffee;
import com.gmail.kirilllapitsky.deliverycaffee.entity.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends CrudRepository<Menu, Long> {
    Optional<Menu> findById(Long id);

    List<Menu> findAllByCaffee(Caffee caffee);
}
