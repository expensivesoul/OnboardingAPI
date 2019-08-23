package jsontest.controller;


import jsontest.model.Dto;


import jsontest.repository.Dtorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController

public class Dtocontroller {


    @Autowired
    Dtorepository repository;


    @PostMapping(value = "/json")
    public void getData( @RequestBody Dto dto) {
        repository.save(dto);
    }

    @GetMapping("/list")
    public List<Dto> list(){
        return (List<Dto>) repository.findAll();

    }
    @GetMapping(value = "/distinct")
    public List<String> checkdistinct(){
        return (List<String>)repository.check();
    }

}
