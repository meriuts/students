package com.example.students.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentModel {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;

    @Override
    public String toString() {
        return System.lineSeparator() + "Идентификатор студента: '" + id + "'" + System.lineSeparator() +
                "Имя студента: '" + firstName + "'" + System.lineSeparator() +
                "Фамилия студента: '" + lastName + "'" + System.lineSeparator() +
                "Возраст студента: '" + age + "'";
    }


}
