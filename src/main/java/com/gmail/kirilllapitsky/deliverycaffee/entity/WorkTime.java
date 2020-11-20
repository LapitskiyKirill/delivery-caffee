package com.gmail.kirilllapitsky.deliverycaffee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "work_time")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "caffee_id")
    private Cafe cafe;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "cafeWorkTime", cascade = CascadeType.ALL)
    List<DayWorkTime> dayWorkTimes;

    public WorkTime(Cafe cafe) {
        this.cafe = cafe;
    }
}
