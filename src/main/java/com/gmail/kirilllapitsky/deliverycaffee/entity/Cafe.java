package com.gmail.kirilllapitsky.deliverycaffee.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "caffee")
@Data
@NoArgsConstructor
public class Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
    @OneToOne
    @JoinColumn(name = "work_time_id")
    private WorkTime workTime;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL)
    private List<User> users;

    public Cafe(String name, String address, WorkTime workTime, List<User> users) {
        this.name = name;
        this.address = address;
        this.workTime = workTime;
        this.users = users;
    }
}