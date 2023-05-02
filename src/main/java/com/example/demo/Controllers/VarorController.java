package com.example.demo.Controllers;
import com.example.demo.Models.Ordering;
import com.example.demo.Models.Varor;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.Repositories.VarorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class VarorController {

    private final VarorRepository repo;
    private final OrderRepository OrderRepo;
    private static final Logger log = LoggerFactory.getLogger(VarorController.class);


    VarorController(VarorRepository repo, OrderRepository OrderRepo){
        this.repo = repo;
        this.OrderRepo=OrderRepo;

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
    /*@PostMapping("varor/addToChart")
    public String VarorAdd(@RequestParam Long costumerId, @RequestParam Long id){
        Ordering order = OrderRepo.findById(costumerId).get();
        if (order != null){
            order.addVaror(new Ordering(saldo, ranta));
            kundRepo.save(kund);
        }
        return "konto lades till hos kund med id "+kundId;
    }
    }*/
}
