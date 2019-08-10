package OnBoardApp.Checklist.controller;

import OnBoardApp.Checklist.model.user;
import OnBoardApp.Checklist.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    userRepository repository;

    @PostMapping("/save")
    public user savedetails(@RequestBody user User){

        repository.save(User);
        return User;
    }


}
