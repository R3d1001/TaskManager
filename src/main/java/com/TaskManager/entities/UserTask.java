package com.TaskManager.entities;

import jakarta.persistence.*;

@Entity
@IdClass(UserTaskPK.class)
public class UserTask {

    @Id
    @ManyToOne
    @JoinColumn(name = "id")
    public Users user;


    @Id
    @ManyToOne
    @JoinColumn(name = "taskID")
    public Tasks task;

}
