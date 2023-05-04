package com.example.demo.Repositories;

import com.example.demo.Models.Items;
import com.example.demo.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByCustomer_Id(Long customerId);
}
