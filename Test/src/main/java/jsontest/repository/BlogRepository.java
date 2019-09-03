package jsontest.repository;



import jsontest.model.UserBlog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoryblog extends CrudRepository<UserBlog,Long> {


    @Query(value="select * from blog order by id desc",nativeQuery = true)
    List<UserBlog> find();
}
