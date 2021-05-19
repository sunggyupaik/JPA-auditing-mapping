package com.example.controller;

import com.example.application.ItemService;
import com.example.domain.item.ItemCreateRequest;
import com.example.domain.item.ItemCreateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("")
    public ItemCreateResponse create(@RequestBody ItemCreateRequest itemCreateRequest) {
        return itemService.createItem(itemCreateRequest);
    }
}
