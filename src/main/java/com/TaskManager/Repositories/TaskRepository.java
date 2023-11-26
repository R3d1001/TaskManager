package com.TaskManager.Repositories;

import com.TaskManager.entities.Tasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Tasks, Integer> {

}
