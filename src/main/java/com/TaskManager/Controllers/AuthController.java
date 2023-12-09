package com.TaskManager.Controllers;

import com.TaskManager.Repositories.UserRepository;
import com.TaskManager.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

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

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(@RequestParam String username, @RequestParam String password,
                               @RequestParam String email, @RequestParam String firstName,
                               @RequestParam String lastName, @RequestParam char gender){

        Users u = new Users();
        u.username = username;
        u.password = password;
        u.email = email;
        u.firstName = firstName;
        u.lastName = lastName;
        u.gender = 'M';

        userRepository.save(u);
        System.out.println("User input");
        return "redirect:login";
    }


    @GetMapping("/hello")
    public String helloPage(){
        return "hello";
    }
}
