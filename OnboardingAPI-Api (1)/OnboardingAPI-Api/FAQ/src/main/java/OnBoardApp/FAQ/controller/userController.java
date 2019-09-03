package OnBoardApp.FAQ.controller;


import OnBoardApp.FAQ.model.user;
import OnBoardApp.FAQ.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/faq")
public class userController {

    @Autowired
    userRepository repository;

    @PostMapping("/save")
    public String savefaq(@RequestBody user User){

        repository.save(User);
        return "Saved";
    }
    @GetMapping("/display")
    public List<user> display(){
        return (List<user>) repository.findAll();
    }
    @GetMapping("/display/{id}")
    public user findById(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @DeleteMapping("/delete")
    public String deletelist(){

        repository.deleteAll();
        return "Deleted";
    }

}
