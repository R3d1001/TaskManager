package com.TaskManager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Task {
    @Id
    public int TaskID;
    public String Name, Description;
    public Date CreationDate, SetDueDate;
    public String Status;
    public int Priority, OwnerUserID;

}
