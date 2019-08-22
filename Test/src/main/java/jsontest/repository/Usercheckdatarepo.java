package jsontest.repository;

import jsontest.model.Usercheckdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;

public interface Usercheckdatarepo extends JpaRepository<Usercheckdata,Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into usercheckdata (phone,checklist_name,data) select phone,checklist_name,data from entity e,user u where u.phone=?1 and e.checklist_name=?2 and not exists(select phone,checklist_name from usercheckdata d where d.phone=?1 and d.checklist_name=?2)", nativeQuery = true)
    public int updatecheck(String phone, String Checklist_name);

}