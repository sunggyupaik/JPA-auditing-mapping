package com.example.application;

import com.example.domain.item.Item;
import com.example.domain.item.ItemCreateRequest;
import com.example.domain.item.ItemCreateResponse;
import com.example.domain.item.ItemGetResponse;
import com.example.repository.ItemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public List<ItemGetResponse> getAllItems() {
        return itemRepository.findAll().stream()
                .map(ItemGetResponse::of)
                .collect(Collectors.toList());
    }

    public ItemGetResponse getItem(Long id) {
        return itemRepository.findById(id)
                .map(ItemGetResponse::of)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ItemCreateResponse createItem(ItemCreateRequest itemCreateRequest) {
        Item item = itemCreateRequest.toEntity();
        Item savedItem = itemRepository.save(item);
        return ItemCreateResponse.of(savedItem);
    }
}
