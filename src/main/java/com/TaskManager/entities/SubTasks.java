package com.TaskManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

@Entity
public class SubTasks {
    @Id
    public int SubtaskID;

    @ManyToOne
    @JoinColumn(name="ParentTaskID")
    public Task ParentTask;
    public String Title, Description;
    public Date DueDate;
    public String Status;
    public String Priority;

    @ManyToOne
    @JoinColumn(name = "AssignedTo")
    public User AssignedTo;
}
