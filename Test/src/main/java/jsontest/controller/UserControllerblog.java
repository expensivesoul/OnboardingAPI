package jsontest.controller;



import jsontest.model.Userblog;
import jsontest.repository.UserRepositoryblog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/blog")
public class UserControllerblog {

    @Autowired
    UserRepositoryblog repository;

    @PostMapping("/save")
    public Userblog save(@RequestBody Userblog User){

        return repository.save(User);
        //return ( bean. User);
        //return "Saved";
    }
    @PutMapping("/update/{id}")
    public Userblog update(@PathVariable Long id , @RequestBody Userblog User){


        Userblog userDetails=repository.findById(id).get();
        userDetails.setTitle(User.getTitle());
        userDetails.setSubject(User.getSubject());
        userDetails.setTextAreaContent(User.getTextAreaContent());
        userDetails.setUrl(User.getUrl());
        Userblog update=repository.save(userDetails);
        return update;


    }
    @GetMapping("/display")
    public List<Userblog> getAllBlog()  {
        return (List<Userblog>) repository.findAll();

    }
    @GetMapping("/display/{id}")
    public Userblog blogById(@PathVariable Long id) {
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
