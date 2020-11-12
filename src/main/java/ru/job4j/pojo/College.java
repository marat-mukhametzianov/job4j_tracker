package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setEnrollmentDate(LocalDate.of(2000, 3, 23));
        student.setGroup("Computer science");
        student.setName("Hassan");
        student.setSurname("Abdruhman");
        student.setPatronymic("Huttab");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String formattedEnrollmentDate = student.getEnrollmentDate().format(formatter);
        System.out.printf(
                "Student %s %s ibn %s.\n" +
                "Group is %s, " +
                "date of the enrollment is %s.",
                student.getName(),
                student.getSurname(),
                student.getPatronymic(),
                student.getGroup(),
                formattedEnrollmentDate
        );
    }
}
