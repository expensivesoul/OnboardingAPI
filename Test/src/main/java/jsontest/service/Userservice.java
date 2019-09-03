package jsontest.service;


import jsontest.model.*;
import jsontest.repository.DtoRepository;
import jsontest.repository.UserDtoRepo;
import jsontest.repository.UserRepository;
import jsontest.repository.UserCheckdataRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    UserCheckdataRepo repo;
    @Autowired
    DtoRepository userrepo;
    @Autowired
    UserDtoRepo userDtoRepo;



    EntityManager entityManager;

    public User usersave(User User) {

        return repository.save(User);

    }


    public List<UserDetails> userlist() {

        return (List<UserDetails>) repository.testuserlist();
    }



    public List<UserCheckdata> data(String phone) {
        return (List<UserCheckdata>) repo.data(phone);

    }

    public int updatecheck(String phone,String checklist_name) {
        System.out.println(phone);

        System.out.println(checklist_name);
        return repo.updatecheck(phone,checklist_name);



    }


    public List<UserCheckdata> usercheck(User phone) {

        return repo.usercheck(phone.getPhone());
    }

    public UserCheckdata userchecksave(UserCheckdata user) {

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

    public void userRegister(UserDto user) {
        userDtoRepo.save(user);

    }
    public int countuser(UserDto user){

        return userDtoRepo.countuser(user.getUsername(),user.getPassword());
    }
    public int countusername(String user){

        return userDtoRepo.countusername(user);
    }

}
