package ru.job4j.pojo;

import java.time.LocalDateTime;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setGroup(2);
        student.setFirstName("John");
        student.setLastName("Snow");
        student.setMiddleName("Snowovich");
        LocalDateTime dateAdmission = LocalDateTime.of(2012, 8, 8, 3, 58);
        student.setDateOfAdmission(dateAdmission);

        System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getMiddleName()
                + " " + student.getGroup() + " " + student.getDateOfAdmission());

    }
}
