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