package com.javainuse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javainuse.dao.userRepositoryfaq;
import com.javainuse.model.userfaq;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/faq")
public class userControllerfaq {

    @Autowired
    userRepositoryfaq repository;

    @PostMapping("/save")
    public String savefaq(@RequestBody userfaq User){

        repository.save(User);
        return "Saved";
    }
    /* @GetMapping("/display/")
     @ResponseBody
     public String findByCategory( @RequestBody String category){
         String userquestion;
         String useranswer;

             user User=repository.findByCategory(category);
              userquestion=String.valueOf(User.getQuestion());
              //useranswer=User.getAnswer();




         return userquestion;

     }*/
    @GetMapping("/display")
    public List<userfaq> display(){
        return (List<userfaq>)repository.findAll();

    }
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
