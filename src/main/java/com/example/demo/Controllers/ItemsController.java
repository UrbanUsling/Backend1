package com.example.demo.Controllers;
import com.example.demo.Models.Item;
import com.example.demo.Repositories.ItemsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ItemsController {

    private final ItemsRepository repo;
    private static final Logger log = LoggerFactory.getLogger(ItemsController.class);


    ItemsController(ItemsRepository repo){
        this.repo = repo;

    }
    //Lista alla varor
    @RequestMapping("items")
    public List<Item> getAllItems(){
        log.info("Alla varor listade");
        return repo.findAll();

    }
    //hitta specifika varor
    @RequestMapping("items/{id}")
    public Item getById(@PathVariable long id){
        return repo.findById(id).get();

    }



}
