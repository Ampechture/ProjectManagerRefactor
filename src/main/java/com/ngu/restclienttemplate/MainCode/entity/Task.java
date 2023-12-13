package com.ngu.restclienttemplate.MainCode.entity;

import jakarta.persistence.*;
import com.ngu.restclienttemplate.entity.User;

import java.util.List;
@Entity
@Table(name = "tasks")
public class Task {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    public Long getUserId() {
        return userId;
    }

    private Long userId;
    public void addProjectId(Long userId){
        this.userId = userId;
    }

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Subtask> subtasks;

    // геттеры и сеттеры
}

