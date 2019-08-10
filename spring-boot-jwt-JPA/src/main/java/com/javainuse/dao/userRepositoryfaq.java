package com.javainuse.dao;


import org.springframework.data.repository.CrudRepository;

import com.javainuse.model.userfaq;

public interface userRepositoryfaq extends CrudRepository<userfaq,Long> {

    //public user findByCategory(String category);
}
