package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.SpecialOffer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpecialOfferRepository extends CrudRepository<SpecialOffer, Long> {
    Optional<SpecialOffer> findById(Long id);

    List<SpecialOffer> findAllByMenuId(Long menuId);
}
