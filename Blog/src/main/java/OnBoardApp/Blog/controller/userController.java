package OnBoardApp.Blog.controller;


import OnBoardApp.Blog.model.user;
import OnBoardApp.Blog.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/blog")
public class userController {

    @Autowired
    userRepository repository;

    @PostMapping("/save")
    public user saveOrUpdate(@RequestBody user User){

        repository.save(User);
        return (User);
    }
    @GetMapping("/display")
    public List<user> getAllBlog()  {
        return (List<user>) repository.findAll();

    }
    @GetMapping("/display/{id}")
    public user blogById(@PathVariable Long id) {
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
