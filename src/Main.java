
import com.studentmanagement.Student;
import com.studentmanagement.StudentManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    Student student =
                            new Student(id, name, age, department);

                    manager.addStudent(student);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    manager.updateStudent(
                            updateId, newName, newAge, newDepartment
                    );
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    manager.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
