package com.example.demo.Controllers;


import com.example.demo.Models.Customer;
import com.example.demo.Repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository repo;
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    CustomerController(CustomerRepository repo){
        this.repo = repo;
    }

    @RequestMapping("customers")
    public List<Customer> getAllCustomers(){
        log.info("All books returned");
        log.error("All books returned in ERROR mess");
        log.warn("All books returned in WARNING mess");
        log.debug("All books returned in DEBUG mess");
        return repo.findAll();
    }
    @RequestMapping("customers/{id}")
    public Customer findById(@PathVariable long id){
        log.info("Costumer found with id "+id);
        return repo.findById(id).get();
    }

    @RequestMapping("customers/{name}/name")
    public List<Customer> findByName(@PathVariable String name){
        return repo.findByName(name);
    }

    @RequestMapping("customers/{id}/delete")
    public List<Customer> deleteById(@PathVariable long id){
        repo.deleteById(id);
        log.info("Costumer deleted with id "+id);
        return repo.findAll();
    }

    @PostMapping("customers/add")
    public List<Customer> addCustomers(@RequestBody Customer b){
        repo.save(b);
        return repo.findAll();
    }


}