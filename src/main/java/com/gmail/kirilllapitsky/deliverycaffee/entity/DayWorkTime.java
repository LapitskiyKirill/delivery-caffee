package com.gmail.kirilllapitsky.deliverycaffee.entity;

import com.gmail.kirilllapitsky.deliverycaffee.enumerable.Days;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "day_work_time")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayWorkTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    private WorkTime workTime;

    public DayWorkTime(Days day, LocalTime openTime, LocalTime closeTime, Boolean isDayOff, WorkTime workTime) {
        this.day = day;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.isDayOff = isDayOff;
        this.workTime = workTime;
    }
}
