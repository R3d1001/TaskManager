package com.TaskManager.Controllers;

import com.TaskManager.Repositories.UserTasksRepository;
import com.TaskManager.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    UserTasksRepository userTasksRepository;

    @GetMapping("/api/tasklist")
    public ResponseEntity<List<Task>> GetTasks(@RequestParam(name = "Email", defaultValue = "") String Email){
        return new ResponseEntity<List<Task>>(userTasksRepository.findByEmail(Email), HttpStatus.OK);
    }

}
