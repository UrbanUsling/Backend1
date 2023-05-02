package com.example.demo.Controllers;

import com.example.demo.Models.Orders;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {
    private final OrdersRepository OrderRepo;
    private final CustomerRepository CustRepo;
    private static final Logger log = LoggerFactory.getLogger(OrdersController.class);

    OrdersController(OrdersRepository OrderRepo, CustomerRepository CustRepo){
        this.OrderRepo = OrderRepo;
        this.CustRepo = CustRepo;

    }
    @RequestMapping("orders")
    public List<Orders> getAllOrders(){
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
