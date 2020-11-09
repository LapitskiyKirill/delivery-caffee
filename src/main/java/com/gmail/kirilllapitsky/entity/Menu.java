package com.gmail.kirilllapitsky.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "caffee_id")
    private Caffee caffee;

    @OneToMany(mappedBy = "menu")
    private List<MenuItems> menuItems;

    @OneToMany(mappedBy = "menu")
    private List<SpecialOffer> specialOffers;
}
