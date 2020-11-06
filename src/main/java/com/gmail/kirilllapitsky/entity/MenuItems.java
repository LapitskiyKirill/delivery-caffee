package com.gmail.kirilllapitsky.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")
@Data
public class MenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "item_id")
    private Long itemId;

}