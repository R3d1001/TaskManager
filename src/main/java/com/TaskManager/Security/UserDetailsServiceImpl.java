//package com.TaskManager.Security;
//
//// UserDetailsServiceImpl.java
//import com.TaskManager.Repositories.UserRepository;
//import com.TaskManager.entities.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
//        Users users = userRepository.findByEmail(Email);
//        if (users == null) {
//            throw new UsernameNotFoundException("User not found with username: " + Email);
//        }
//        return org.springframework.security.core.userdetails.User
//                .withUsername(users.email)
//                .password(users.password)
//                .roles("USER") // You can set roles here
//                .build();
//    }
//}
