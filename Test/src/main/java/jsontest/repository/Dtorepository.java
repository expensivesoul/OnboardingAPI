package jsontest.repository;


import jsontest.model.Dto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dtorepository extends JpaRepository<Dto,Long>{

    @Query(value="Select checklist_name from entity",nativeQuery = true)
    public List<String> check();

    @Query(value = "select c.checklist_name,c.status,c.data from entity c,user u,assign a where a.phone=u.phone and a.checklist_name=c.checklist_name and u.phone= ?1",nativeQuery = true)
    public List<Dto> data(String phone);

    /*@Query(value="select data from entity where checklist_name=?1")
    public List<Documents> checkdata(String checklist_name);*/

}
