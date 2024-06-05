package com.example.students.event;

import com.example.students.model.StudentModel;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class Event extends ApplicationEvent {
    private StudentModel student;
    private String eventType;

    public Event(Object source, StudentModel student, String eventType) {
        super(source);
        this.student = student;
        this.eventType = eventType;
    }
}
