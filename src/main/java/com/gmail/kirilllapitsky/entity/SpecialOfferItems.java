package com.gmail.kirilllapitsky.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "special_offer_items")
@Data
public class SpecialOfferItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private SpecialOffer specialOffer;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item specialOfferItem;
}
