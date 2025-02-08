package kz.bitlab.springapp.db;

import kz.bitlab.springapp.model.Student;

import java.util.ArrayList;


public class DBManager {
    private static ArrayList<Student> students = new ArrayList<>();

    static{
        students.add(new Student(1L, "nurzhan", "izimbetov", 95L, "A"));
        students.add(new Student(2L, "nurzhan", "izimbetov", 95L, "A"));
        students.add(new Student(3L, "nurzhan", "izimbetov", 45L, "F"));
    }

    public static ArrayList<Student> getAllStudents() {
        return students;
    }

    public static String calculateGrade(Long mark) {
        if (mark >= 90) {
            return "A";
        } else if (mark >= 75) {
            return "B";
        } else if (mark >= 60) {
            return "C";
        } else if (mark >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void addStudent(Student student) {
        int studentLastIdx = students.size() - 1;
        students.add(new Student(students.get(studentLastIdx).getId() + 1, student.getName(), student.getSurname(), student.getExamScore(), calculateGrade(student.getExamScore())));
    }
}
