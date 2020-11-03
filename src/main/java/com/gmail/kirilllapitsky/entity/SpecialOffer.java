package com.gmail.kirilllapitsky.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "special_offer")
@Data
public class SpecialOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "review")
    private String review;
}
