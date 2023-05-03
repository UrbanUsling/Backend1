package com.example.demo.Controllers;

import com.example.demo.Models.Customer;
import com.example.demo.Models.Items;
import com.example.demo.Models.Orders;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.ItemsRepository;
import com.example.demo.Repositories.OrdersRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrdersController {
    private final OrdersRepository OrderRepo;
    private final CustomerRepository CustRepo;
    private final ItemsRepository ItemsRepo;
    private static final Logger log = LoggerFactory.getLogger(OrdersController.class);

    OrdersController(OrdersRepository OrderRepo, CustomerRepository CustRepo, ItemsRepository ItemsRepo){
        this.OrderRepo = OrderRepo;
        this.CustRepo = CustRepo;
        this.ItemsRepo= ItemsRepo;

    }
    @RequestMapping("orders")
    public List<Orders> getAllOrders(){
        return OrderRepo.findAll();
    }
    /*@RequestMapping("orders/{customerId}")
    public List<Orders> findById(@PathVariable String customerId){
        log.info("Order found with costumer id "+customerId);
        return OrderRepo.findById(customerId);
    }*/
    @RequestMapping("orders/add/{ItemsId}/{CustomerId}")
    public String addItems(@PathVariable Long ItemsId, @PathVariable Long CustomerId){
        Customer customer = CustRepo.findById(CustomerId).get();
        Items item = ItemsRepo.findById(ItemsId).get();

        Orders k1 = new Orders((LocalDate.now()).toString(), customer);
        OrderRepo.save(k1);
        k1.addItems(item);


        return "konto lades till hos kund med id "+CustomerId;
    }

}
