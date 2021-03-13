package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.WorkTime;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WorkTimeRepository extends CrudRepository<WorkTime, Long> {
    Optional<WorkTime> findById(Long id);
}
