package com.studentmanagement;

import com.studentmanagement.Student;

import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;
    private FileHandling fileHandling;


    public StudentManager() {
        fileHandling = new FileHandling();
        students = fileHandling.loadStudents();
    }


    public void addStudent(Student student) {

        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        fileHandling.saveStudents(students);

        System.out.println("Student added successfully!");
    }


    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }


    public void updateStudent(int id, String name,
                              int age, String department) {

        for (Student s : students) {

            if (s.getId() == id) {

                s.setName(name);
                s.setAge(age);
                s.setDepartment(department);

                fileHandling.saveStudents(students);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }


    public void deleteStudent(int id) {

        Student found = null;

        for (Student s : students) {
            if (s.getId() == id) {
                found = s;
                break;
            }
        }

        if (found != null) {
            students.remove(found);
            fileHandling.saveStudents(students);

            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}

