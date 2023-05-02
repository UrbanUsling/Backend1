package com.example.demo.Controllers;

import com.example.demo.Models.Costumer;
import com.example.demo.Models.Ordering;
import com.example.demo.Repositories.CostumerRepository;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.Repositories.VarorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderRepository OrderRepo;
    private final CostumerRepository CostRepo;
    private final VarorRepository VaruRepo;
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    OrderController(OrderRepository OrderRepo, CostumerRepository CostRepo, VarorRepository VaruRepo){
        this.OrderRepo = OrderRepo;
        this.CostRepo = CostRepo;
        this.VaruRepo = VaruRepo;

    }
    @RequestMapping("orders")
    public List<Ordering> getAllOrders(){
        log.info("All books returned");
        log.error("All books returned in ERROR mess");
        log.warn("All books returned in WARNING mess");
        log.debug("All books returned in DEBUG mess");
        return OrderRepo.findAll();
    }
   /* @RequestMapping("orders/{customerId}")
    public Ordering findById(@PathVariable long costumerId){
        log.info("Costumer found with id "+costumerId);
        return OrderRepo.findById(costumerId).get();
    }*/

}
