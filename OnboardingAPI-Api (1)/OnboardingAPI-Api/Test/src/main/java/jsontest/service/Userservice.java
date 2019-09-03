package jsontest.service;


import jsontest.Security.PasswordEncoder;
import jsontest.model.*;
import jsontest.repository.Dtorepository;
import jsontest.repository.UserDtoRepo;
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
    @Autowired
    UserDtoRepo userDtoRepo;
    @Autowired
    private PasswordEncoder bcryptEncoder;



    EntityManager entityManager;

    public User usersave(User User) {

        return repository.save(User);

    }


    public List<Userdetails> userlist() {

        return (List<Userdetails>) repository.testuserlist();
    }



    public List<Usercheckdata> data(String phone) {
        return (List<Usercheckdata>) repo.data(phone);

    }

    public int updatecheck(String phone,String checklist_name) {
        System.out.println(phone);

        System.out.println(checklist_name);
        return repo.updatecheck(phone,checklist_name);



    }


    public List<Usercheckdata> usercheck(User phone) {

        return repo.usercheck(phone.getPhone());
    }

    public Usercheckdata userchecksave(Usercheckdata user) {

        return repo.save(user);
    }

    public int usercheckcount(String phone) {
        System.out.println("service wala phone"+phone);
        return repo.countint(phone);
    }


    public List<NameAndPhone> nameandphone() {

        return repository.nameandphone();
    }
    public void deletecheck(String checkname) {
        userrepo.deleteByChecklist_name(checkname);

    }

    public void userRegister(UserDto newuser) {
        UserDto user=new UserDto();
        user.setUsername(newuser.getUsername());
        user.setPassword(bcryptEncoder.encode(newuser.getPassword()));
        userDtoRepo.save(user);

    }

    public int countusername(String user){

        return userDtoRepo.countusername(user);
    }

    public String getname(String phone) {
        return repository.getName(phone);
    }

    public boolean PhoneExist(String phone) {
        if(repository.getPhone(phone)>0)
        {
        return true ;
        }
        return false;

    }

    public boolean alreadyassign(String phone, String name) {
        System.out.println("asidggsaidgiugdiqudguqigdwqiudg   "+repo.alreadyassign(phone,name));
        if(repo.alreadyassign(phone,name)>0){
            return false;
        }


        return true;
    }


    public String findpass(String username) {
        return userDtoRepo.findpass(username);
    }

    public boolean checkpass(String rawpassword, String encryptpass) {
        return bcryptEncoder.matches(rawpassword,encryptpass);

    }
}
