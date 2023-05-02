package com.example.demo.Repositories;

import com.example.demo.Models.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Ordering, Long> {

    public List<Ordering> findByDate(String date);
}
