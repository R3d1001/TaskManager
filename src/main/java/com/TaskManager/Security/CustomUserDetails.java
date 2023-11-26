//package com.TaskManager.Security;
//
//import com.TaskManager.entities.Users;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//
//
//public class CustomUserDetails implements UserDetails {
//
//    private Users users;
//
//    public CustomUserDetails(Users users) {
//        super();
//        this.users = users;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("User"));
//    }
//
//    @Override
//    public String getPassword() {
//        return users.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return users.email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}