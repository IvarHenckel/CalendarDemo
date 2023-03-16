package com.ivarsexample.calendardemo.repository;

import com.ivarsexample.calendardemo.model.Content;
import com.ivarsexample.calendardemo.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//We are only declaring an interface which extends from another interface (ListCrudRepository)
//So how is an instance actually created?
//I guess that when ContentRepository is AutoWired into where it is used, Spring Data is able
//to create a suitable implementation of ListCrudRepository<Content, Integer>?
//Android Room actually worked the same way.
public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    //There are two ways we can write more queries
    //Derived Queries - Spring will implement the query for you just by the name! (!!!)
    //Of course, there are rules regarding these names!
    List<Content> findAllByTitleContains(String keyword);

    // You can also describe the query similar to Room DB Queries like this
    @Query("SELECT * FROM Content WHERE status = :status")
    List<Content> listByStatus(@Param("status") Status status);

    // You should also be able to call functions explicitly and filter programmatically! But I haven't tried that yet.

}
