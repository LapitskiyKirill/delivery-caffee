package com.gmail.kirilllapitsky.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "caffee")
@Data
public class Caffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "work_time")
    private String workTime;

    @OneToMany(mappedBy = "caffee")
    private List<User> users;

    public Caffee(String name, String address, String workTime) {
        this.name = name;
        this.address = address;
        this.workTime = workTime;
    }
}
