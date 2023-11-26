package com.TaskManager.Repositories;

import com.TaskManager.entities.Tasks;
import com.TaskManager.entities.UserTask;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTasksRepository extends CrudRepository<UserTask, Integer> {

    @Query("SELECT task FROM UserTask ut WHERE ut.user.email = :email")
    List<Tasks> findByEmail(@Param("email") String email);

}
