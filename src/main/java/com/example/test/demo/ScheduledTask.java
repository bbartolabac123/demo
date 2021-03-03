package com.example.test.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.test.demo.Entity.Status;
import com.example.test.demo.Entity.Task;
import com.example.test.demo.Services.TaskService;

@Component
public class ScheduledTask {
    
    @Autowired
    private TaskService taskService;

	@Scheduled(fixedRate = 15000)
	public void reportCurrentTime() {
        Task task = new Task();
        task.setTitle("Task Title");
        task.setDescription("Task Description");
        task.setDueDate(new Date());
        task.setStatus(Status.INPROGRESS);
        task.setPriority(1);
        taskService.create(task);
	}
    
}
