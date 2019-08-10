package OnBoardApp.BlogandFaqOnBoardApp.repository;


import OnBoardApp.BlogandFaqOnBoardApp.model.userfaq;
import org.springframework.data.repository.CrudRepository;

public interface userRepositoryfaq extends CrudRepository<userfaq,Long> {

    //public user findByCategory(String category);
}
