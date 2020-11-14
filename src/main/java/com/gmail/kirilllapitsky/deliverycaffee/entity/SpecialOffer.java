package com.gmail.kirilllapitsky.deliverycaffee.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "special_offer")
@Data
@NoArgsConstructor
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

    @OneToMany(mappedBy = "specialOffer")
    private List<SpecialOfferItems> specialOfferItems;
}
