package jsontest.repository;


import jsontest.model.Dto;
import jsontest.model.Usercheckdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Dtorepository extends JpaRepository<Dto,Long>{

    @Query(value="Select checklist_name from entity",nativeQuery = true)
    public List<String> check();

    @Modifying
    @Transactional
    @Query(value="delete from entity where checklist_name=?1",nativeQuery = true)
    public void deleteByChecklist_name(String checkname);

    @Query(value="select * from entity order by date desc",nativeQuery = true)
    List<Dto >find();


    /*@Query(value="select data from entity where checklist_name=?1")
    public List<Documents> checkdata(String checklist_name);*/

}
