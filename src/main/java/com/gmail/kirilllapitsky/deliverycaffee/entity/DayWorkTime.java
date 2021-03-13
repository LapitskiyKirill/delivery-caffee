package com.gmail.kirilllapitsky.deliverycaffee.entity;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Days;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "day_work_time")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DayWorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "day")
    private Days day;

    @Column(name = "start_time")
    private LocalTime openTime;

    @Column(name = "end_time")
    private LocalTime closeTime;

    @Column(name = "day_off")
    private Boolean isDayOff;

    @ManyToOne
    @JoinColumn(name = "work_time_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    public WorkTime cafeWorkTime;
}
