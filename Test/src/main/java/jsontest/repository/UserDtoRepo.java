package jsontest.repository;

import jsontest.model.UserDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDtoRepo extends CrudRepository<UserDto,Long> {


    @Query(value = "select count(*) from user_dto  where username=?1 and password=?2 ",nativeQuery = true)
    public int countuser(String username,String password);
    @Query(value = "select count(*) from user_dto  where username=?1 ",nativeQuery = true)
    int countusername(String user);
}
