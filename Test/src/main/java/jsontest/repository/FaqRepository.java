package jsontest.repository;



import jsontest.model.UserFaq;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoryfaq extends CrudRepository<UserFaq,Long> {


    //public user findByCategory(String category);
     @Query(value = "Select * from faq where category = ?1",nativeQuery = true)
    List<UserFaq> findbyCategory(String category);

    @Query(value = "select distinct category from faq",nativeQuery = true)
     List<String> distinctCategory();
}
