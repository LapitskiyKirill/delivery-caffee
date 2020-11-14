package com.gmail.kirilllapitsky.deliverycaffee.repository;

import com.gmail.kirilllapitsky.deliverycaffee.entity.SpecialOfferItems;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialOfferItemsRepository extends CrudRepository<SpecialOfferItems, Long> {
    List<SpecialOfferItems> findAllBySpecialOfferId(Long specialOfferId);
}
