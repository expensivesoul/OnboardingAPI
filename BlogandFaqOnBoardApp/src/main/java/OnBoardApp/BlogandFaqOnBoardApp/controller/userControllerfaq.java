package OnBoardApp.BlogandFaqOnBoardApp.controller;


import OnBoardApp.BlogandFaqOnBoardApp.model.userfaq;
import OnBoardApp.BlogandFaqOnBoardApp.repository.userRepositoryfaq;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@CrossOrigin
@RestController
@RequestMapping("/faq")
public class userControllerfaq {

    @Autowired
    userRepositoryfaq repository;
    //userRepositoryfaq repo;

    @PostMapping("/save")
    public String savefaq(@RequestBody userfaq User){

        //repo.save(User);
        repository.save(User);
        return "Saved";
    }

    @GetMapping("/displayall")
    public List<userfaq> displayall(){

        return (List<userfaq>)repository.findAll();
    }
    @PostMapping("/display")
    public List<userfaq> display(@RequestBody userfaq category){

        return repository.findByCategory(category.getCategory());

    }
    /*@GetMapping("/distinct")
    public List<userfaq> distinct(){

        return repository.distinctCategory();
    }*/


    @GetMapping("/display/{id}")
    public userfaq findById(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @DeleteMapping("/delete")
    public String deletelist(){

        repository.deleteAll();
        return "Deleted";
    }

}
