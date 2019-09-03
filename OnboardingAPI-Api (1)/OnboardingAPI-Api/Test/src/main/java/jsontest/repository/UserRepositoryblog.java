package jsontest.repository;



import jsontest.model.Userblog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoryblog extends CrudRepository<Userblog,Long> {

    @Query(value="select * from blog order by id desc",nativeQuery = true)
    public List<Userblog> findblog();
}
