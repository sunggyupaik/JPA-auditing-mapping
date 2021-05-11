package com.example.repository;

import com.example.domain.item.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Optional<Item> findById(Long id);

    List<Item> findAll();

    Item save(Item item);

    void deleteAll();
}
