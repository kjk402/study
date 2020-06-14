package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;


public class ItemRepositoryTest extends StudyApplicationTests {


    @Autowired
    private ItemRepository itemRepository;


    @Test
    public void create(){

        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("삼성노트북");
        item.setTitle("notebook9");
        item.setContent("2020년형 노트북.");
        item.setPrice(BigDecimal.valueOf(900000));
        item.setBrandName("SAMSUNG");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        //item.setPartnerId(3L);

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);


    }

    @Test
    public void read(){


    }



}