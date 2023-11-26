package com.TaskManager.Repositories;

import com.TaskManager.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {


    Users findByEmail(String Email);

}
