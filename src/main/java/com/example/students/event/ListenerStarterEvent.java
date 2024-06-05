package com.example.students.event;

import com.example.students.model.StudentModel;
import com.example.students.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty("app.student-starter.enabled")
public class ListenerStarterEvent {
    private final StudentRepository studentRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void handleStarterEvent() {
        for (int i = 0; i < 5; i++) {
            StudentModel student = StudentModel.builder()
                    .id(UUID.randomUUID().toString())
                    .firstName("Иван")
                    .lastName("Иванов")
                    .age(44)
                    .build();
            studentRepository.saveStudent(student);
        }
    }
}
