package com.TaskManager.Repositories;

import com.TaskManager.entities.Tasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Tasks, Integer> {

    List<Tasks> findByTaskID(@Param("TaskID") int TaskID);

}
