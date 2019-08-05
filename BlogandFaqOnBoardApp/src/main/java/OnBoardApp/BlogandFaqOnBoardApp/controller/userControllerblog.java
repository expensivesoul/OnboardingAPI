package OnBoardApp.BlogandFaqOnBoardApp.controller;


import OnBoardApp.BlogandFaqOnBoardApp.model.userblog;
import OnBoardApp.BlogandFaqOnBoardApp.repository.userRepositoryblog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/blog")
public class userControllerblog {

    @Autowired
    userRepositoryblog repository;

    @PostMapping("/save")
    public userblog save(@RequestBody userblog User){

        repository.save(User);
        return (User);
    }
    @PutMapping("/update/{id}")
    public userblog update(@PathVariable Long id , @RequestBody userblog User){


        userblog userDetails=repository.findById(id).get();
        userDetails.setTitle(User.getTitle());
        userDetails.setSubject(User.getSubject());
        userDetails.setContent(User.getContent());
        userDetails.setUrl(User.getUrl());
        userblog update=repository.save(userDetails);
        return update;


    }
    @GetMapping("/display")
    public List<userblog> getAllBlog()  {
        return (List<userblog>) repository.findAll();

    }
    @GetMapping("/display/{id}")
    public userblog blogById(@PathVariable Long id) {
        return repository.findById(id).get();

    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return "Deleted Blog With Id="+id;
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        repository.deleteAll();
        return"Deleted All Blogs";
    }
}
