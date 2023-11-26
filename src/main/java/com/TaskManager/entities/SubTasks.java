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
    @JoinColumn(name="parentTaskID")
    public Task parentTask;
    public String title, description;
    public Date dueDate;
    public String status;
    public String priority;

    @ManyToOne
    @JoinColumn(name = "assignedTo")
    public Users assignedTo;
}
