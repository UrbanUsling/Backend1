package com.example.demo.RESTAPI;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VarorRepository extends JpaRepository<Varor, Long> {

    public List<Varor> findByNamn(String vara);
}
