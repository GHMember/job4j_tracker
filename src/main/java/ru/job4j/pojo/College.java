package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setStudentName("Иванов Петр Петрович");
        student.setStudentClass("ПИ-1");
        student.setAdmissionDate("01.09.2022");
        System.out.println(
                  "ФИО: " + student.getStudentName() + System.lineSeparator()
                + "Группа: " + student.getStudentClass() + System.lineSeparator()
                + "Дата поступления: " + student.getAdmissionDate()
        );
    }
}
