package jsontest.repository;



import jsontest.model.Userfaq;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoryfaq extends CrudRepository<Userfaq,Long> {


    //public user findByCategory(String category);
     @Query(value = "Select * from faq where category = ?1",nativeQuery = true)
    List<Userfaq> findbyCategory(String category);

    @Query(value = "select distinct category from faq",nativeQuery = true)
     List<String> distinctCategory();


    @Query(value="select * from faq order by id desc",nativeQuery = true)
    public List<Userfaq> findfaq();
}
