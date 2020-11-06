package com.gmail.kirilllapitsky.service;

import com.gmail.kirilllapitsky.dto.FeedbackDto;
import com.gmail.kirilllapitsky.dto.ItemDto;
import com.gmail.kirilllapitsky.dto.MenuDto;
import com.gmail.kirilllapitsky.repository.*;
import com.gmail.kirilllapitsky.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {
    private final SpecialOfferItemsRepository specialOfferItemsRepository;
    private final SpecialOfferRepository specialOfferRepository;
    private final ItemRepository itemRepository;
    private final FeedBackRepository feedBackRepository;
    private final MenuRepository menuRepository;
    private final MenuItemsRepository menuItemsRepository;
    private final SpecialOfferService specialOfferService;


    public MenuService(SpecialOfferItemsRepository specialOfferItemsRepository, SpecialOfferRepository specialOfferRepository, ItemRepository itemRepository, FeedBackRepository feedBackRepository, MenuRepository menuRepository, MenuItemsRepository menuItemsRepository, SpecialOfferService specialOfferService) {
        this.specialOfferItemsRepository = specialOfferItemsRepository;
        this.specialOfferRepository = specialOfferRepository;
        this.itemRepository = itemRepository;
        this.feedBackRepository = feedBackRepository;
        this.menuRepository = menuRepository;
        this.menuItemsRepository = menuItemsRepository;
        this.specialOfferService = specialOfferService;
    }

    public MenuDto findById(Long id) {
        MenuDto menu = Mapper.map(menuRepository.findById(id).get(), MenuDto.class);
        List<ItemDto> menuItems = Mapper.mapList(menuItemsRepository.findAllByMenuId(id).stream()
                .map(i -> itemRepository.findById(
                        i.getItemId())
                        .orElseThrow())
                .collect(Collectors.toList()), ItemDto.class);
        menuItems.forEach(i -> i.setFeedbackDto(Mapper.mapList(feedBackRepository.findAllByItemId(i.getId()), FeedbackDto.class)));
        menu.setItems(menuItems);
        menu.setSpecialOffers(specialOfferService.findSpecialOffersItemsByMenuId(id));
        return menu;
    }

}
