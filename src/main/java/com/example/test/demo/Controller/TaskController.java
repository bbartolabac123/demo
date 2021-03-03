package com.example.test.demo.Controller;

import java.util.List;

import com.example.test.demo.DTO.TaskDTO;
import com.example.test.demo.Entity.Task;
import com.example.test.demo.Services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    @ResponseBody
    public List<TaskDTO> getAllTask() {
        List<TaskDTO> taskDTOs = taskService.getAllTask();
        return taskDTOs;
    }

    @PostMapping("/tasks")
    @ResponseBody
    public TaskDTO create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @GetMapping("/tasks/{id}")
    @ResponseBody
    public TaskDTO findTask(@PathVariable("id") Long id) {
        return taskService.getTask(id);
    }

    @PutMapping("/tasks/{id}")
    @ResponseBody
    public TaskDTO put(@RequestBody Task task, @PathVariable("id") Long id) {
        return taskService.put(task, id);
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") Long id){
        taskService.delete(id);
        return "Successfully Delete";
    }

}
