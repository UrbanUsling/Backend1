package com.example.demo.Repositories;

import com.example.demo.Models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Long> {

    public List<Items> findByNamn(String vara);
    public List<Items> findItemsByOrdersId(Long OrdersId);
}
