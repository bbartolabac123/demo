package com.example.test.demo.DTO;

import java.util.Date;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import com.example.test.demo.Entity.Status;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class TaskDTO {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Date dueDate;
    private Date resolvedAt;
    private String title;
    private String description;
    private int priority;
    private Status status;
}
