package com.example.demo.Repositories;

import com.example.demo.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


    public interface CustomerRepository extends JpaRepository<Customer, Long> {

        public List<Customer> findByName(String name);


    }

