package OnBoardApp.BlogandFaqOnBoardApp.repository;


import OnBoardApp.BlogandFaqOnBoardApp.model.userfaq;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.TypedQuery;
import java.awt.*;
import java.util.List;

public interface userRepositoryfaq extends CrudRepository<userfaq,Long> {


    public user findByCategory(String category);
        @Query(value = "Select * from faq where category = ?1",nativeQuery = true)
    List<userfaq> findByCategory( String category );

    @Query(value = "select distinct category from faq",nativeQuery = true)
     List<userfaq> distinctCategory();
}
