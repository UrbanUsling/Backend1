package com.example.demo.Controllers;
import com.example.demo.Models.Items;
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
    public List<Items> getAllItems(){
        log.info("Alla varor listade");
        return repo.findAll();

    }
    //hitta specifika varor
    @RequestMapping("items/{id}")
    public Items getById(@PathVariable long id){
        return repo.findById(id).get();

    }
    //Hitta genom varunamn
    @RequestMapping("items/{item}/item")
    public List<Items> findByItem(@PathVariable String item){
        return repo.findByNamn(item);
    }
    //ta bort varor
    @RequestMapping("items/{id}/delete")
    public List<Items> deleteById(@PathVariable long id){
        repo.deleteById(id);
        log.info("Tagit bort varan med id " + id);
        return repo.findAll();

    }
    @PostMapping("items/add")
    public List<Items> addItems(@RequestBody Items i){
        repo.save(i);
        return repo.findAll();

    }
}
