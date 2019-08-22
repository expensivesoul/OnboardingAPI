package jsontest.service;


import jsontest.model.*;
import jsontest.repository.Dtorepository;
import jsontest.repository.Userrepository;
import jsontest.repository.Usercheckdatarepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class Userservice {

    @Autowired
    Userrepository repository;
    @Autowired
    Usercheckdatarepo repo;
    @Autowired
    Dtorepository userrepo;

    EntityManager entityManager;

    public User usersave(User User) {

        return repository.save(User);

    }


    public List<Userdetails> userlist() {

        return (List<Userdetails>) repository.testuserlist();
    }



    public List<Dto> data(String phone) {
        return (List<Dto>) userrepo.data(phone);

    }

    public int updatecheck(String phone,String checklist_name) {
        System.out.println(phone);

        System.out.println(checklist_name);
        return repo.updatecheck(phone,checklist_name);



    }


}
