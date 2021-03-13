package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.DayWorkTime;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DayWorkTimeRepository extends CrudRepository<DayWorkTime, Long> {
    Optional<DayWorkTime> findById(Long id);
}
