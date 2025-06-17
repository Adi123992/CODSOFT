import java.util.Scanner;

public class StudentGradeCaulculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int n = s.nextInt();

        int[] marks = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = s.nextInt();
            total += marks[i];
        }

        double average = (double) total / n;
        String grade;

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        s.close();
    }
}
 

