package com.TaskManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;
    public String username;
    public String password;
    public String email;
    public String firstName;
    public String lastName;
    public char gender;


}
