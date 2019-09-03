package jsontest.controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jsontest.model.Userblog;
import jsontest.repository.UserRepositoryblog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/blog")
@Api(value="test")
public class UserControllerblog {

    @Autowired
    UserRepositoryblog repository;
    @ApiOperation(value = "Save new Blog ")
    @PostMapping("/save")
    public Userblog save(@RequestBody Userblog User){

        Pattern pattern = Pattern.compile("img src=\"(.*?)\"");
        Matcher matcher = pattern.matcher(User.getTextAreaContent());
        if (matcher.find()) {

            User.setUrl(matcher.group(1));
        }
        else
            User.setUrl("https://www.nineleaps.com/wp-content/themes/nineleaps/assets/img/work-days-time-10.svg");

        return repository.save(User);
        //return ( bean. User);
        //return "Saved";
    }
    @ApiOperation(value = "Update Blog", response = ResponseEntity.class)
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
    @ApiOperation(value = "Display all blogs")
    @GetMapping("/display")
    public List<Userblog> getAllBlog()  {
        return (List<Userblog>) repository.find();

    }
    @ApiOperation(value = "Display all parricular blogs by ID")
    @GetMapping("/display/{id}")
    public Userblog blogById(@PathVariable Long id) {
        return repository.findById(id).get();

    }
    @ApiOperation(value = "Delete particular blog by ID")
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        repository.deleteById(id);
        return "Deleted Blog With Id="+id;
    }
    @ApiOperation(value = "Delete all blogs")
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        repository.deleteAll();
        return"Deleted All Blogs";
    }


}
