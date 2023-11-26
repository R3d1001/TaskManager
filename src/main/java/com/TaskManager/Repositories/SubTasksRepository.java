package com.TaskManager.Repositories;

import com.TaskManager.entities.Comments;
import com.TaskManager.entities.SubTasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTasksRepository extends CrudRepository<SubTasks, Integer> {

}
