package com.ngu.restclienttemplate.MainCode.entity;

import jakarta.persistence.*;
import com.ngu.restclienttemplate.entity.User;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "tasks")
public class Task {



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

    public Long getId() {
        return id;
    }

    private Long userId;

    /*@ManyToMany
    @JoinTable(
            name="tasksUser ",
            joinColumns = @JoinTable(name="task_id"),
            inverseJoinColumns = @JoinTable(name = "user_id")
    )
    public List<User> usersIdentity;*/

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Subtask> subtasks;

    // геттеры и сеттеры
}

