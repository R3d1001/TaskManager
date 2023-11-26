package com.TaskManager.Repositories;

import com.TaskManager.entities.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer> {

}