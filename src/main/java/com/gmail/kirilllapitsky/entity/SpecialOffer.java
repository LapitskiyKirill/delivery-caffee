package com.gmail.kirilllapitsky.entity;

import io.swagger.models.auth.In;
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
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "description_id")
    private Description description;

    @Column(name = "cost")
    private Integer cost;
}
