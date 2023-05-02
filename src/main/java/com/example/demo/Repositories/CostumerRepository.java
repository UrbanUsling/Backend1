package com.example.demo.Repositories;

import com.example.demo.Models.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


    public interface CostumerRepository extends JpaRepository<Costumer, Long> {

        public List<Costumer> findByName(String name);
        //public List<Costumer> findById(long customerId);

    }

