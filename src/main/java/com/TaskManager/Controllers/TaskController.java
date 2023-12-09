package com.TaskManager.Controllers;

import com.TaskManager.Repositories.CommentsRepository;
import com.TaskManager.Repositories.TaskRepository;
import com.TaskManager.Repositories.UserRepository;
import com.TaskManager.Repositories.UserTasksRepository;
import com.TaskManager.entities.Comments;
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
import org.springframework.ui.Model;
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
    CommentsRepository commentsRepository;

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("tasklist")
    public String GetTasks(Model model, @RequestParam(name="task", defaultValue = "-1") String taskID ){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<Tasks> tasks = userTasksRepository.findByEmail(userDetails.getUsername());
        int input = Integer.parseInt(taskID);
        Tasks task;
        if(input == -1) task = tasks.get(0);
        else task = taskRepository.findByTaskID(input).get(0);
        model.addAttribute("Task", task);
        model.addAttribute("tasklist", userTasksRepository.findByEmail(userDetails.getUsername()));
        List<Users> userList = userTasksRepository.findByTaskID(input);
        String emails = "";
        for (Users u : userList) emails += u.email + ", ";
        model.addAttribute("userList", emails);
        model.addAttribute("Comments", commentsRepository.findByTaskID(input));
            return "TaskView";
    }

    @PostMapping(path="/createtask") // Map ONLY POST Requests
    public String addNewTask (@RequestParam String name, @RequestParam String description,
                              @RequestParam String DueDate, @RequestParam int priority, @RequestParam String emails) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        String[] emailList = emails.split(" ");
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

        for(String e : emailList){
            Users user = userRepository.findByEmail(e);
            ut = new UserTask();
            ut.task = t;
            ut.user = user;
            userTasksRepository.save(ut);

        }


        return "redirect:createtask";
    }

    @GetMapping("/createtask")
    public String CreateTask(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        model.addAttribute("tasks",userTasksRepository.findByEmail(userDetails.getUsername()));
        return "TaskCreation";
    }

    @GetMapping("/api/tasklist")
    public ResponseEntity<Tasks> GetTasksapi(Model model, @RequestParam(name="task", defaultValue = "-1") String taskID ){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<Tasks> tasks = userTasksRepository.findByEmail(userDetails.getUsername());
        int input = Integer.parseInt(taskID);
        Tasks task;
        if(input == -1) task = tasks.get(0);
        else task = taskRepository.findByTaskID(input).get(0);
        model.addAttribute("Task", task);
        model.addAttribute("tasks", tasks);
        return new ResponseEntity<Tasks>(task, HttpStatus.OK );
    }

    @PostMapping("/api/addcomment")
    public String addComment(@RequestParam int taskID, @RequestParam String Description){
        Comments comment = new Comments();
        comment.Description = Description;
        comment.task = taskRepository.findByTaskID(taskID).get(0);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        comment.users = userRepository.findByEmail(userDetails.getUsername());

        commentsRepository.save(comment);
        return "redirect:/tasklist?task=" + taskID;
    }
}
