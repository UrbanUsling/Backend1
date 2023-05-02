package com.example.demo.Controllers;


import com.example.demo.Models.Costumer;
import com.example.demo.Repositories.CostumerRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.ServletContextResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class CostumerController {

    private final CostumerRepository repo;
    private static final Logger log = LoggerFactory.getLogger(CostumerController.class);

    CostumerController(CostumerRepository repo){
        this.repo = repo;
    }

    @RequestMapping("costumers")
    public List<Costumer> getAllCostumers(){
        log.info("All books returned");
        log.error("All books returned in ERROR mess");
        log.warn("All books returned in WARNING mess");
        log.debug("All books returned in DEBUG mess");
        return repo.findAll();
    }
    @RequestMapping("costumers/{id}")
    public Costumer findById(@PathVariable long id){
        log.info("Costumer found with id "+id);
        return repo.findById(id).get();
    }

    @RequestMapping("costumers/{name}/name")
    public List<Costumer> findByName(@PathVariable String name){
        return repo.findByName(name);
    }

    @RequestMapping("costumers/{id}/delete")
    public List<Costumer> deleteById(@PathVariable long id){
        repo.deleteById(id);
        log.info("Costumer deleted with id "+id);
        return repo.findAll();
    }

    @PostMapping("costumers/add")
    public List<Costumer> addCostumers(@RequestBody Costumer b){
        repo.save(b);
        return repo.findAll();
    }


}