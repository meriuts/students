package com.example.students.service;

import com.example.students.event.Event;
import com.example.students.model.StudentModel;
import com.example.students.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.UUID;

@ShellComponent
@RequiredArgsConstructor
public class StudentShell {
    private final StudentRepository studentRepository;
    private final ApplicationEventPublisher eventPublisher;

    @ShellMethod(key = "add")
    public void addStudent(@ShellOption(value = "fn") String firstName,
                           @ShellOption(value = "ln") String lastName,
                           @ShellOption(value = "a") Integer age) {
        StudentModel student = StudentModel.builder()
                .id(UUID.randomUUID().toString())
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .build();
        studentRepository.saveStudent(student);
        eventPublisher.publishEvent(new Event(this, student, "add"));
    }

    @ShellMethod(key = "ls")
    public String findAllStudents() {
        return studentRepository.findAllStudents();

    }

    @ShellMethod(key = "rm")
    public void deleteStudentById(@ShellOption(value = "id") String id) {
        StudentModel student = studentRepository.deleteStudentById(id);
        eventPublisher.publishEvent(new Event(this, student, "rm"));
    }

    @ShellMethod(key = "rm --all")
    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();
    }

}
