package com.TaskManager.Controllers;

import com.TaskManager.Repositories.UserRepository;
import com.TaskManager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String LoginPage(){
        return "login";
    }


//    @PostMapping("/login")
//    public String loginPage(@RequestParam("Email") String Email, @RequestParam("Password") String Password){
//        User user = userRepository.findByEmail(Email);
//        if (Password.equals(user.Password)){
//
//        }
//        return "login";
//    }




    @GetMapping("/hello")
    public String helloPage(){
        return "hello";
    }
}
