package com.example.infra;

import com.example.domain.item.Item;
import com.example.repository.ItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaItemRepository
        extends ItemRepository, JpaRepository<Item, Long> {
    Optional<Item> findById(Long id);

    List<Item> findAll();

    Item save(Item item);

    void deleteAll();
}
