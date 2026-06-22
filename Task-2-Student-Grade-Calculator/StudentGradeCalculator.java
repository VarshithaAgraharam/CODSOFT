import java.util.Scanner;

public class {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== STUDENT GRADE CALCULATOR =====");

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        double totalMarks = 0;

        for (int i = 1; i <= subjects; i++) {

            System.out.print("Enter Marks for Subject " + i + ": ");
            double marks = sc.nextDouble();

            totalMarks += marks;
        }

        double percentage = totalMarks / subjects;

        String grade;

        if (percentage >= 90)
            grade = "A+";
        else if (percentage >= 80)
            grade = "A";
        else if (percentage >= 70)
            grade = "B";
        else if (percentage >= 60)
            grade = "C";
        else if (percentage >= 50)
            grade = "D";
        else
            grade = "F";

        System.out.println("\n===== RESULT =====");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
