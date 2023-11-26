package com.TaskManager.Controllers;

import com.TaskManager.Repositories.TaskRepository;
import com.TaskManager.Repositories.UserRepository;
import com.TaskManager.Repositories.UserTasksRepository;
import com.TaskManager.entities.Tasks;
import com.TaskManager.entities.UserTask;
import com.TaskManager.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    UserTasksRepository userTasksRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/api/tasklist")
    public ResponseEntity<List<Tasks>> GetTasks(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new ResponseEntity<List<Tasks>>(userTasksRepository.findByEmail(userDetails.getUsername()), HttpStatus.OK);
    }

    @PostMapping(path="/api/createtask") // Map ONLY POST Requests
    public String addNewTask (@RequestParam String name, @RequestParam String description,
                              @RequestParam String DueDate, @RequestParam int priority) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Tasks t = new Tasks();
        t.name = name;
        t.description = description;
        t.priority = priority;
        t.creationDate = new Timestamp(System.currentTimeMillis());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        Users u = userRepository.findByEmail(email);
        t.owner = u;
        t.setDueDate = Timestamp.valueOf(DueDate);
        t.status = "incomplete";
        taskRepository.save(t);

        UserTask ut = new UserTask();
        ut.task = t;
        ut.user = u;
        userTasksRepository.save(ut);

        return "redirect:/api/tasklist";
    }

    @GetMapping("/createtask")
    public String CreateTask(){
        return "TaskCreation";
    }

}
