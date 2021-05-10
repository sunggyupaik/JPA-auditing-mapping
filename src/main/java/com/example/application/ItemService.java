package com.example.application;

import com.example.domain.item.Item;
import com.example.domain.item.ItemCreateRequest;
import com.example.domain.item.ItemCreateResponse;
import com.example.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemCreateResponse createItem(ItemCreateRequest itemCreateRequest) {
        Item item = itemCreateRequest.toEntity();
        Item savedItem = itemRepository.save(item);
        return ItemCreateResponse.of(savedItem);
    }
}
