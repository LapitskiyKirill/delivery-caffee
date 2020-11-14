package com.gmail.kirilllapitsky.deliverycaffee.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "description_id")
    private Description description;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "discount")
    private Integer discount;

    @OneToMany(mappedBy = "item")
    private List<Feedback> feedback;
}