package com.example.test.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.test.demo.Entity.Task;


@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    
}
