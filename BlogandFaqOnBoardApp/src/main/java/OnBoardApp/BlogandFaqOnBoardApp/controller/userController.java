package OnBoardApp.BlogandFaqOnBoardApp.controller;


import OnBoardApp.BlogandFaqOnBoardApp.model.user;
import OnBoardApp.BlogandFaqOnBoardApp.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    userRepository repository;

    @PostMapping("/save")
    public user savedetails(@RequestBody user User){
        System.out.println(User);
        repository.save(User);
        return User;
    }
    @GetMapping("/display")
        public List<user> display(){
        //System.out.print
        return (List<user>)repository.findAll();
        }


}
