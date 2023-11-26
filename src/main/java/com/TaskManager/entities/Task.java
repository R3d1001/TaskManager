package com.TaskManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Task {
    @Id
    public int taskID;
    public String name, description;
    public Date creationDate, setDueDate;
    public String status;
    public int priority, ownerUserID;

}
