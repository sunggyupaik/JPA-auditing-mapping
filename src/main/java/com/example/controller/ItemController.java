package com.example.controller;

import com.example.application.ItemService;
import com.example.domain.item.ItemCreateRequest;
import com.example.domain.item.ItemCreateResponse;
import com.example.domain.item.ItemGetResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public List<ItemGetResponse> getAll() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemGetResponse get(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemCreateResponse create(@RequestBody ItemCreateRequest itemCreateRequest) {
        return itemService.createItem(itemCreateRequest);
    }
}
