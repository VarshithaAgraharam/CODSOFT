import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private int rollNo;
    private String name;
    private String grade;

    public Student(int rollNo, String name, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.grade = grade;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static {
        students.add(new Student(101, "Varshitha", "A"));
        students.add(new Student(102, "Rahul", "B+"));
        students.add(new Student(103, "Sneha", "A+"));
        students.add(new Student(104, "Arjun", "A"));
        students.add(new Student(105, "Priya", "B"));
        students.add(new Student(106, "Kiran", "A+"));
        students.add(new Student(107, "Ananya", "A"));
        students.add(new Student(108, "Rohit", "B+"));
        students.add(new Student(109, "Divya", "A"));
        students.add(new Student(110, "Vikram", "B"));
    }

    public static void addStudent() {

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                System.out.println("Roll Number already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        students.add(new Student(rollNo, name, grade));

        System.out.println("Student added successfully!");
    }

    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s%n",
                "Roll No", "Name", "Grade");
        System.out.println("--------------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-10d %-20s %-10s%n",
                    s.getRollNo(),
                    s.getName(),
                    s.getGrade());
        }

        System.out.println("--------------------------------------------------");
    }

    public static void searchStudent() {

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();

        for (Student s : students) {

            if (s.getRollNo() == rollNo) {

                System.out.println("\nStudent Found");
                System.out.println("-------------------------");
                System.out.println("Roll No : " + s.getRollNo());
                System.out.println("Name    : " + s.getName());
                System.out.println("Grade   : " + s.getGrade());
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void updateStudent() {

        System.out.print("Enter Roll Number to Update: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {

            if (s.getRollNo() == rollNo) {

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Grade: ");
                String grade = sc.nextLine();

                s.setName(name);
                s.setGrade(grade);

                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void deleteStudent() {

        System.out.print("Enter Roll Number to Delete: ");
        int rollNo = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getRollNo() == rollNo) {

                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void totalStudents() {
        System.out.println("Total Students: " + students.size());
    }

    public static void sortStudents() {

        Collections.sort(students,
                Comparator.comparingInt(Student::getRollNo));

        System.out.println("Students sorted by Roll Number.");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Total Students");
            System.out.println("7. Sort Students");
            System.out.println("8. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    totalStudents();
                    break;

                case 7:
                    sortStudents();
                    break;

                case 8:
                    System.out.println("Thank you for using the Student Management System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
