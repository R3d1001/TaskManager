package com.TaskManager.entities;

import jakarta.persistence.*;

@Entity
@IdClass(UserTaskPK.class)
public class UserTask {

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    public User user;


    @Id
    @ManyToOne
    @JoinColumn(name = "TaskID")
    public Task task;

}
