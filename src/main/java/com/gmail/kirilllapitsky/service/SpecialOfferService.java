package com.gmail.kirilllapitsky.service;

import com.gmail.kirilllapitsky.dto.FeedbackDto;
import com.gmail.kirilllapitsky.dto.ItemDto;
import com.gmail.kirilllapitsky.dto.SpecialOfferDto;
import com.gmail.kirilllapitsky.entity.SpecialOffer;
import com.gmail.kirilllapitsky.repository.FeedBackRepository;
import com.gmail.kirilllapitsky.repository.ItemRepository;
import com.gmail.kirilllapitsky.repository.SpecialOfferItemsRepository;
import com.gmail.kirilllapitsky.repository.SpecialOfferRepository;
import com.gmail.kirilllapitsky.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialOfferService {
    private final SpecialOfferItemsRepository specialOfferItemsRepository;
    private final SpecialOfferRepository specialOfferRepository;
    private final ItemRepository itemRepository;
    private final FeedBackRepository feedBackRepository;

    public SpecialOfferService(SpecialOfferItemsRepository specialOfferItemsRepository, SpecialOfferRepository specialOfferRepository, ItemRepository itemRepository, FeedBackRepository feedBackRepository) {
        this.specialOfferItemsRepository = specialOfferItemsRepository;
        this.specialOfferRepository = specialOfferRepository;
        this.itemRepository = itemRepository;
        this.feedBackRepository = feedBackRepository;
    }

    public SpecialOfferDto findSpecialOfferItemsById(Long id) {
        SpecialOfferDto offer = Mapper.map(specialOfferRepository.findById(id).orElseThrow(), SpecialOfferDto.class);
        List<ItemDto> items = Mapper.mapList(specialOfferItemsRepository.findAllBySpecialOfferId(id).stream()
                .map(i -> itemRepository.findById(
                        i.getItemId())
                        .orElseThrow())
                .collect(Collectors.toList()), ItemDto.class);
        items.forEach(i -> i.setFeedbackDto(Mapper.mapList(feedBackRepository.findAllByItemId(i.getId()), FeedbackDto.class)));
        offer.setItems(items);
        return offer;
    }

    public List<SpecialOfferDto> findSpecialOffersItemsByMenuId(Long menuId) {
        List<SpecialOfferDto> offers = Mapper.mapList(specialOfferRepository.findAllByMenuId(menuId), SpecialOfferDto.class);
        offers.forEach(o -> {
            List<ItemDto> items = Mapper.mapList(specialOfferItemsRepository.findAllBySpecialOfferId(o.id).stream()
                    .map(i -> itemRepository.findById(
                            i.getItemId())
                            .orElseThrow())
                    .collect(Collectors.toList()), ItemDto.class);
            items.forEach(i -> i.setFeedbackDto(Mapper.mapList(feedBackRepository.findAllByItemId(i.getId()), FeedbackDto.class)));
            o.setItems(items);
        });
        return offers;
    }
}