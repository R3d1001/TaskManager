package com.TaskManager.Repositories;

import com.TaskManager.entities.Comments;
import com.TaskManager.entities.Tasks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer> {

    @Query("SELECT c FROM Comments c WHERE c.task.taskID = :TaskID")
    List<Comments> findByTaskID(@Param("TaskID") int TaskID);
}