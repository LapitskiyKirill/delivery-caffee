package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.MenuItems;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuItemsRepository extends CrudRepository<MenuItems, Long> {
    List<MenuItems> findAllByMenuId(Long menuId);
}
