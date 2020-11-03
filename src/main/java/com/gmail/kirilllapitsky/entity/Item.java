package com.gmail.kirilllapitsky.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "menu_id")
    private List<Menu> menu;

    @OneToOne
    @JoinColumn(name = "description_id")
    private Description description;

    @Column(name = "cost")
    private int cost;

    @Column(name = "discount")
    private int discount;
}