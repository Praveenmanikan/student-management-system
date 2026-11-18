package com.studentmanagement;

import java.util.ArrayList;


import java.io.*;


public class FileHandling {

    private final String FILE_NAME = "students.txt";


    public void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student s : students) {
                writer.write(s.getId() + "," +
                        s.getName() + "," +
                        s.getAge() + "," +
                        s.getDepartment());

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }


    public ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length == 4) {
                    try {
                        int id = Integer.parseInt(data[0]);
                        String name = data[1];
                        int age = Integer.parseInt(data[2]);
                        String department = data[3];

                        students.add(
                                new Student(id, name, age, department)
                        );

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid record skipped.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading records: " + e.getMessage());
        }

        return students;
    }
}

