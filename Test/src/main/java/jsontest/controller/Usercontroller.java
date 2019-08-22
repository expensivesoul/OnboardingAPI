package jsontest.controller;


import jsontest.model.*;
import jsontest.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/final")

public class Usercontroller {

    @Autowired
    Userservice service;

    @PostMapping("/save")
    public User usersave(@RequestBody User User){

        return service.usersave(User);
    }
    @PostMapping("/assign")
    public int insertQuery(@RequestBody Map<String,String> checkdata) {

        return  service.updatecheck(checkdata.get("phone"),checkdata.get("checklist_name"));

    }


    @GetMapping("/listuser")
    public List<Userdetails> userlist(){

        return service.userlist();
    }

    @PostMapping("/data")
    public List<Dto> data(@RequestBody User phone){
        return service.data(phone.getPhone());

    }


}
