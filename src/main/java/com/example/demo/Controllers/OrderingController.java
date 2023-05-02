package com.example.demo.Controllers;
import com.example.demo.Models.Ordering;
import com.example.demo.Repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderingController {

    private final OrderRepository repo;
    private static final Logger log = LoggerFactory.getLogger(CostumerController.class);

    OrderingController(OrderRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("orders")
    public List<Ordering> getAllCostumers() {
        log.info("All books returned");
        log.error("All books returned in ERROR mess");
        log.warn("All books returned in WARNING mess");
        log.debug("All books returned in DEBUG mess");
        return repo.findAll();
    }

    @RequestMapping("orders/{name}/name")
    public List<Ordering> findByName(@PathVariable String name) {
        return repo.findByName(name);
    }

}