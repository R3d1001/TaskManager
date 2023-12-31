package com.TaskManager.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int taskID;
    public String name, description;
    public Timestamp creationDate, setDueDate;
    public String status;
    public int priority;

    @ManyToOne
    @JoinColumn(name = "ownerUserID")
    public Users owner;

}
