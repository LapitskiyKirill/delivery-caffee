package com.gmail.kirilllapitsky.repository;

import com.gmail.kirilllapitsky.entity.MenuItems;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuItemsRepository extends CrudRepository<MenuItems, Long> {
    List<MenuItems> findAllByMenuId(Long menuId);
}
