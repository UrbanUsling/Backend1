package RESTAPI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VarorController {

    private final VarorRepository repo;

    VarorController(VarorRepository repo){
        this.repo = repo;

    }
    @RequestMapping("/varor")
    public List<Varor> getAllVaror(){
        return repo.findAll();

    }

}
