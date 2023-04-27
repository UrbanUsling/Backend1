package com.example.demo.RESTAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class VarorController {

    private final VarorRepository repo;
    private static final Logger log = LoggerFactory.getLogger(VarorController.class);


    VarorController(VarorRepository repo){
        this.repo = repo;

    }
    //Lista alla varor
    @RequestMapping("varor")
    public List<Varor> getAllVaror(){
        log.info("Alla varor listade");
        return repo.findAll();

    }
    //hitta specifika varor
    @RequestMapping("varor/{id}")
    public Varor getById(@PathVariable long id){
        return repo.findById(id).get();

    }
    //Hitta genom varunamn
    @RequestMapping("varor/{vara}/vara")
    public List<Varor> findByVara(@PathVariable String vara){
        return repo.findByNamn(vara);
    }
    //ta bort varor
    @RequestMapping("varor/{id}/delete")
    public List<Varor> deleteById(@PathVariable long id){
        repo.deleteById(id);
        log.info("Tagit bort varan med id " + id);
        return repo.findAll();

    }
    @PostMapping("varor/add")
    public List<Varor> addVaror(@RequestBody Varor v){
        repo.save(v);
        return repo.findAll();

    }
}
