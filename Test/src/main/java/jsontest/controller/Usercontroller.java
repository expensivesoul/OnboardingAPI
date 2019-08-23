package jsontest.controller;


import jsontest.model.*;
import jsontest.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public void insertQuery(@RequestBody Map<String,String> checkdata) {
            System.out.println(checkdata);
            String[] value=checkdata.get("selections").split(",");
            for (int i=0;i<value.length;i++) {
                service.updatecheck(checkdata.get("phone"), value[i]);
            }
    }


    @GetMapping("/listuser")
    public List<Userdetails> userlist(){

        return service.userlist();
    }

    @PostMapping("/data")
    public List<Dto> data(@RequestBody User phone){
        return service.data(phone.getPhone());

    }
    @PostMapping("/usercheck")
    public List<Usercheckdata> usercheck(@RequestBody User phone){

        return service.usercheck(phone);
    }

    @PostMapping("/updatecheck")
    public Usercheckdata userchecksave(@RequestBody Usercheckdata User){

        return service.userchecksave(User);
    }


}
