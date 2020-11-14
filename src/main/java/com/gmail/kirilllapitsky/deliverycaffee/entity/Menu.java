package com.gmail.kirilllapitsky.deliverycaffee.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
@Data
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "caffee_id")
    private Caffee caffee;

    @ManyToMany
    @JoinTable(
            name = "menu_items",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> menuItems;

    @OneToMany(mappedBy = "menu")
    private List<SpecialOffer> specialOffers;
}
