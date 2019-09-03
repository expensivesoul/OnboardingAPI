package jsontest.controller;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jsontest.model.Userfaq;
import jsontest.repository.UserRepositoryfaq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/faq")
@Api(value="test")
public class UserControllerfaq {

    @Autowired
    UserRepositoryfaq repository;
    //userRepositoryfaq repo;
    @ApiOperation(value = "Save new FAQ")
    @PostMapping("/save")
    public String savefaq(@RequestBody Userfaq User){

        //repo.save(User);
        repository.save(User);
        return "Saved";
    }
    @ApiOperation(value = "Display all Faqs")
    @GetMapping("/displayall")
    public List<Userfaq> displayall(){

        return (List<Userfaq>)repository.findAll();
    }
    @ApiOperation(value = "Display all Faqs by categories")
    @PostMapping("/display")
    public List<Userfaq> display(@RequestBody Userfaq category){

        return repository.findbyCategory(category.getCategory());

    }
    @ApiOperation(value = "Send particular  Faq Categories")
    @GetMapping("/distinct")
    public List<String> distinct(){

        return repository.distinctCategory();
    }

    @ApiOperation(value = "Display particular Faq by Id")
    @GetMapping("/display/{id}")
    public Userfaq findById(@PathVariable Long id){
        return repository.findById(id).get();
    }
    @DeleteMapping("/delete")
    public String deletelist(){

        repository.deleteAll();
        return "Deleted";
    }
    @ApiOperation(value = "Delete particular Faq by Id")
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return "Deleted Faq With Id="+id;
    }

}
