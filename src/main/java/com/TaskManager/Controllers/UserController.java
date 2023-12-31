package com.TaskManager.Controllers;

import com.TaskManager.Repositories.UserRepository;
import com.TaskManager.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/users")
    public ResponseEntity<List<Users>> getUsers(){
        return new ResponseEntity<List<Users>>((List<Users>) userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/users/byemail")
    public ResponseEntity<Users> getUsersbyEmail(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new ResponseEntity<Users>(userRepository.findByEmail(userDetails.getUsername()), HttpStatus.OK);
    }


}
