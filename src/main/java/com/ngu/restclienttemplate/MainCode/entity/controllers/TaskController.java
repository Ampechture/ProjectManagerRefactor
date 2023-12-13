package com.ngu.restclienttemplate.MainCode.entity.controllers;


import com.ngu.restclienttemplate.MainCode.entity.*;

import com.ngu.restclienttemplate.MainCode.entity.repository.TaskRepository;
import com.ngu.restclienttemplate.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("newTask", new Task());
        model.addAttribute("newSubtask", new Subtask());
        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(Task task) {
        if (taskRepository.existsByprojectName(task.getProjectName())){return "WrongLoginData";
        }else {
            task.setId(userService.getUserId());
            taskRepository.save(task);

            return "redirect:/";
        }
    }

    @PostMapping("/addSubtask/{projectId}")
    public String addSubtask(@PathVariable Long projectId, Subtask subtask) {
        Optional<Task> taskOptional = taskRepository.findById(projectId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            subtask.setProject(task);
            task.getSubtasks().add(subtask);
            taskRepository.save(task);
        }
        return "redirect:/project/{projectId}";
    }
    @PostMapping("/addSubtask/delete")
    public void deleteTask(@PathVariable Task task) {
        Optional<Task> taskOptional = taskRepository.findById(task.getId());
        if (taskOptional.isPresent()){
            taskRepository.deleteById(task.getId());
        }
    }


    @GetMapping("/project/{projectId}")
    public String projectPage(@PathVariable Long projectId, Model model) {
        Optional<Task> taskOptional = taskRepository.findById(projectId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            model.addAttribute("task", task);
            model.addAttribute("newSubtask", new Subtask());
            return "project";
        } else {
            return "redirect:/";
        }
    }
}

