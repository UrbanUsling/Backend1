package com.example.demo.Controllers;

import com.example.demo.Models.Costumer;
import com.example.demo.Models.Order;
import com.example.demo.Repositories.CostumerRepository;
import com.example.demo.Repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class OrderController {
    private final OrderRepository OrderRepo;
    private final CostumerRepository CostRepo;
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    OrderController(OrderRepository OrderRepo, CostumerRepository CostRepo){
        this.OrderRepo = OrderRepo;
        this.CostRepo = CostRepo;

    }
    @RequestMapping("orders")
    public List<Order> getAllOrders(){
        log.info("All books returned");
        log.error("All books returned in ERROR mess");
        log.warn("All books returned in WARNING mess");
        log.debug("All books returned in DEBUG mess");
        return OrderRepo.findAll();
    }
    /*@RequestMapping("orders/{customerId}")
    public List<Order> findById(@PathVariable String customerId){
        log.info("Order found with costumer id "+customerId);
        return OrderRepo.findById(customerId);
    }*/

}
