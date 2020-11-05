package com.gmail.kirilllapitsky.repository;

import com.gmail.kirilllapitsky.entity.SpecialOffer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpecialOfferRepository extends CrudRepository<SpecialOffer, Long> {
    Optional<SpecialOffer> findById(Long id);
}
