package com.TaskManager.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class SubTasks {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int SubtaskID;

    @ManyToOne
    @JoinColumn(name="parentTaskID")
    public Tasks parentTask;
    public String title, description;
    public Date dueDate;
    public String status;
    public String priority;

    @ManyToOne
    @JoinColumn(name = "assignedTo")
    public Users assignedTo;
}
