package com.example.demo.Repositories;

import com.example.demo.Models.Items;
import com.example.demo.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    //Behövs för att kunna koppla leta i ordrar och koppla de till kunder för sökfunktioner.
    List<Orders> findAllByCustomer_Id(Long customerId);
}
