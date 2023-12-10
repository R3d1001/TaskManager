package com.TaskManager.entities;

import jakarta.persistence.*;

@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;

    @ManyToOne
    @JoinColumn(name = "taskID")
    public Tasks task;

    @ManyToOne
    @JoinColumn(name = "userID")
    public Users users;


    public String Description;

}
