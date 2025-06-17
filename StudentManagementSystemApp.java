import java.util.*;
import java.io.*;

class Student {
    String name;
    int rollNumber;
    String grade;

    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String toString() {
        return rollNumber + "," + name + "," + grade;
    }

    public static Student fromString(String line) {
        String[] parts = line.split(",");
        return new Student(parts[1], Integer.parseInt(parts[0]), parts[2]);
    }
}

class StudentManagementSystem {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully.\n");
    }

    void removeStudent(int roll) {
        boolean removed = false;
        for (Student s : students) {
            if (s.rollNumber == roll) {
                students.remove(s);
                System.out.println("Student removed.\n");
                removed = true;
                break;
            }
        }
        if (!removed) System.out.println("Student not found.\n");
    }

    void searchStudent(int roll) {
        for (Student s : students) {
            if (s.rollNumber == roll) {
                System.out.println("Student Found:");
                System.out.println("Name: " + s.name);
                System.out.println("Roll Number: " + s.rollNumber);
                System.out.println("Grade: " + s.grade + "\n");
                return;
            }
        }
        System.out.println("Student not found.\n");
    }

    void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.\n");
            return;
        }
        System.out.println("All Students:");
        for (Student s : students) {
            System.out.println("Name: " + s.name + ", Roll: " + s.rollNumber + ", Grade: " + s.grade);
        }
        System.out.println();
    }

    void saveToFile(String filename) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename));
            for (Student s : students) {
                pw.println(s);
            }
            pw.close();
            System.out.println("Data saved to file.\n");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    void loadFromFile(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) return;

            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Student s = Student.fromString(line);
                students.add(s);
            }
            fileScanner.close();
            System.out.println("Data loaded from file.\n");
        } catch (IOException e) {
            System.out.println("Error loading file.");
        }
    }
}

public class StudentManagementSystemApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();
        system.loadFromFile("students.txt");

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save and Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = s.nextLine();
                System.out.print("Enter Roll Number: ");
                int roll = s.nextInt();
                s.nextLine();
                System.out.print("Enter Grade: ");
                String grade = s.nextLine();

                if (name.isEmpty() || grade.isEmpty()) {
                    System.out.println("Invalid input. All fields required.\n");
                } else {
                    system.addStudent(new Student(name, roll, grade));
                }

            } else if (choice == 2) {
                System.out.print("Enter Roll Number to Remove: ");
                int roll = s.nextInt();
                system.removeStudent(roll);

            } else if (choice == 3) {
                System.out.print("Enter Roll Number to Search: ");
                int roll = s.nextInt();
                system.searchStudent(roll);

            } else if (choice == 4) {
                system.displayAll();

            } else if (choice == 5) {
                system.saveToFile("students.txt");
                System.out.println("Exiting Program.");
                break;

            } else {
                System.out.println("Invalid Choice.\n");
            }
        }

        s.close();
    }
}

