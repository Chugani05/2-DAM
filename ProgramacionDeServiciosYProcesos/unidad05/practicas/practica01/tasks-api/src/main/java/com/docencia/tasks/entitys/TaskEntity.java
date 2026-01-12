package com.docencia.tasks.entitys;

import jakarta.persistence.*;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private boolean completed;

    public TaskEntity() {}

    public TaskEntity(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
