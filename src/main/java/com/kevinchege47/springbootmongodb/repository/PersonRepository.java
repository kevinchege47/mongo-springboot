package com.kevinchege47.springbootmongodb.repository;

import com.kevinchege47.springbootmongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    //    This is a case sensitive search.
//    List<Person> findByFirstNameStartsWith(String name);

    //    This is a case insensitive search.

    List<Person> findByFirstNameStartsWithIgnoreCase(String name);

//    List<Person> findByAgeBetween(Integer minAge, Integer maxAge);
    @Query(value = "{'age':{$gt:?0,$lte:?1}}",fields = "{addresses: 0}")
    List<Person> findPersonByAgeBetween(Integer minAge, Integer maxAge);


}
