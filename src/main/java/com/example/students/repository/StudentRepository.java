package com.example.students.repository;

import com.example.students.model.StudentModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class StudentRepository {
    private final Map<String, StudentModel> studentRepository = new HashMap<>();

    public void saveStudent(StudentModel student) {
        studentRepository.put(student.getId(), student);
    }

    public String findAllStudents() {
        StringBuilder stringBuilder = new StringBuilder("Список студентов:");
        for (StudentModel student: studentRepository.values()) {
            stringBuilder.append(student.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public StudentModel deleteStudentById(String id) {
        return studentRepository.remove(id);
    }

    public void deleteAllStudents() {
        studentRepository.clear();
    }


}
