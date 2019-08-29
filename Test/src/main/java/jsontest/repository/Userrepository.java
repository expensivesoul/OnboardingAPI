package jsontest.repository;


import jsontest.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Userrepository extends CrudRepository<User,String> {

    @Query(value = "select id,name,phone,email,place,designation from user",nativeQuery = true)
    public List<Userdetails> testuserlist();



    @Query(value = "select name,phone from user ",nativeQuery = true)
    public List<NameAndPhone> nameandphone();



}
