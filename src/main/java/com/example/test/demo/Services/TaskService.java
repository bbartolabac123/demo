package com.example.test.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.test.demo.DTO.TaskDTO;

import com.example.test.demo.Entity.Task;
import com.example.test.demo.Repository.TaskRepository;

@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> getAllTask() {
        return ((List<Task>) taskRepository.findAll())
                .stream()
                .map(this::convertToTaskDTO)
                        .collect(Collectors.toList());
    }

    public TaskDTO create(Task task) {
        return convertToTaskDTO(taskRepository.save(task));
    }

    public TaskDTO getTask(Long id) {
        return convertToTaskDTO(taskRepository.findById(id).get());
    }

    public TaskDTO put(Task task, Long id) {
        Task task2 = taskRepository.findById(id).get();
        task2.setDescription(task.getDescription());
        task2.setTitle(task.getTitle());
        task2.setDueDate(task.getDueDate());
        task2.setPriority(task.getPriority());
        task2.setStatus(task.getStatus());
        task2.setResolvedAt(task.getResolvedAt());
        return convertToTaskDTO(taskRepository.save(task2));
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskDTO convertToTaskDTO(Task task) {
        TaskDTO taskDto = new TaskDTO();
        taskDto.setId(task.getId());
        taskDto.setCreatedAt(task.getCreatedAt());
        taskDto.setUpdatedAt(task.getUpdatedAt());
        taskDto.setDueDate(task.getDueDate());
        taskDto.setDescription(task.getDescription());
        taskDto.setPriority(task.getPriority());
        taskDto.setResolvedAt(task.getResolvedAt());
        taskDto.setStatus(task.getStatus());
        taskDto.setTitle(task.getTitle());
        return taskDto;
    }
}
