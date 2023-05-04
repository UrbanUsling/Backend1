package com.example.demo.Repositories;

import com.example.demo.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Item, Long> {

    public List<Item> findByNamn(String vara);
    //public List<Item> findItemsByOrdersId(Long OrdersId);
}
