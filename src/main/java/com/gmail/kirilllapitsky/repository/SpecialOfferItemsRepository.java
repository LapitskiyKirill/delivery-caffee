package com.gmail.kirilllapitsky.repository;

import com.gmail.kirilllapitsky.entity.SpecialOfferItems;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialOfferItemsRepository extends CrudRepository<SpecialOfferItems, Long> {
    List<SpecialOfferItems> findAllBySpecialOfferId(Long specialOfferId);
}
