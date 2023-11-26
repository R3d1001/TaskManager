package com.TaskManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comments {

    @Id
    public int id;

    @ManyToOne
    @JoinColumn(name = "taskID")
    public Task task;

    @ManyToOne
    @JoinColumn(name = "userID")
    public Users users;

}
