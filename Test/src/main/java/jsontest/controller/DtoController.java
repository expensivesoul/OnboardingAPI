package jsontest.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jsontest.model.Dto;


import jsontest.repository.Dtorepository;
import jsontest.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin
@RestController
@Api(value="test")
public class Dtocontroller {


    @Autowired
    Dtorepository repository;
    @Autowired
    Userservice userservice;
    @ApiOperation(value = "Save the newly created checklist")
    @PostMapping(value = "/json")

    public void getData( @RequestBody Dto dto) {
        LocalDate today = LocalDate.now();
        dto.setDate(today.toString());

        repository.save(dto);
    }
    @ApiOperation(value = "Display all available checklists", response = List.class)
    @GetMapping("/list")
    public List<Dto> list(){
        return (List<Dto>) repository.find();

    }
    @ApiOperation(value = "Display Distinct Checklists name", response = List.class)
    @GetMapping(value = "/distinct")
    public List<String> checkdistinct()
    {
        return (List<String>)repository.check();
    }
    @DeleteMapping("/delete/{checklist_name}")
    public void deletecheck(@PathVariable String checklist_name) {
        System.out.println("test"+checklist_name);
        userservice.deletecheck(checklist_name);
    }

}
