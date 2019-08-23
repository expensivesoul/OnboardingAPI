package jsontest.controller;



import jsontest.model.Userfaq;
import jsontest.repository.UserRepositoryfaq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/faq")
public class UserControllerfaq {

    @Autowired
    UserRepositoryfaq repository;
    //userRepositoryfaq repo;

    @PostMapping("/save")
    public String savefaq(@RequestBody Userfaq User){

        //repo.save(User);
        repository.save(User);
        return "Saved";
    }

    @GetMapping("/displayall")
    public List<Userfaq> displayall(){

        return (List<Userfaq>)repository.findAll();
    }
    @PostMapping("/display")
    public List<Userfaq> display(@RequestBody Userfaq category){

        return repository.findbyCategory(category.getCategory());

    }
    @GetMapping("/distinct")
    public List<String> distinct(){

        return repository.distinctCategory();
    }


    @GetMapping("/display/{id}")
    public Userfaq findById(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @DeleteMapping("/delete")
    public String deletelist(){

        repository.deleteAll();
        return "Deleted";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return "Deleted Faq With Id="+id;
    }

}
