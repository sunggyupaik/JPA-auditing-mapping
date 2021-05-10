package com.example.infra;

import com.example.domain.item.Item;
import com.example.repository.ItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaItemRepository
        extends ItemRepository, JpaRepository<Item, Long> {
    Item save(Item item);
}
