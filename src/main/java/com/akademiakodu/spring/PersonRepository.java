package com.akademiakodu.spring;

import com.akademiakodu.spring.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lukasz Kolacz on 30.05.2017.
 */

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
