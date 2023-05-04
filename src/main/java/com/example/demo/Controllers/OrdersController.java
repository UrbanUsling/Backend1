package com.example.demo.Controllers;

import com.example.demo.Models.Customer;
import com.example.demo.Models.Item;
import com.example.demo.Models.Orders;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Repositories.ItemsRepository;
import com.example.demo.Repositories.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @RequestMapping("orders/{customerId}")
    public List<Orders> findById(@PathVariable Long customerId){
        if (OrderRepo.findAllByCustomer_Id(customerId)==null){
            log.info("Order NOT found with costumer id "+customerId);
            return null;
        }
        log.info("Order found with costumer id "+customerId);
        return OrderRepo.findAllByCustomer_Id(customerId);
    }
    @RequestMapping("orders/add/{ItemsId}/{CustomerId}")
    public String addItems(@PathVariable Long ItemsId, @PathVariable Long CustomerId){
        Customer customer = CustRepo.findById(CustomerId).get();
        Item item = ItemsRepo.findById(ItemsId).get();

        Orders k1 = new Orders((LocalDate.now()).toString(), customer);
        k1.addItems(item);
        OrderRepo.save(k1);
        log.info("Order created with customer ID "+CustomerId + " and items id " + ItemsId );


        return "konto lades till hos kund med id "+CustomerId;
    }

}
