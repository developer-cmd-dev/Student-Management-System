import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem {
    ArrayList<Student> studentList;
    Scanner sc;

    public ManagementSystem() {
        studentList = new ArrayList<>();
        sc = new Scanner(System.in);
    }


    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void showStudentList() {
        for (Student students : studentList) {
            System.out.println("Name: " + students.getName() + " RollNO :" + students.getRollNo() + " Age: " + students.getAge() + " " + "Stream:" + students.getStream() + " Section: " + students.getSection());
        }
    }


    public void menu() {
        System.out.println("==========*** IIT Student Management System ***==========");

        int choice = 0;
        while (true) {
            System.out.println("1]. Add Student \t\t\t\t 2].List All Student");
            System.out.println("3]. Find Student \t\t\t\t 4].Update Student");
            System.out.println("5]. Delete Student \t\t\t\t 6].Exit");
            System.out.print("Enter your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                boolean exitToAdd = true;
                while (exitToAdd) {
                    System.out.println("=====*** Add Student ***=====");
                    System.out.println("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Student Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Stream: ");
                    String stream = sc.nextLine();
                    System.out.println("Enter Student Section: ");
                    String section = sc.nextLine();
                    addStudent(new Student(name, studentList.size() + 1, age, stream, section));
                    System.out.println("Student Data added Successfully");
                    System.out.println("Do you want to stop: (Y/N)");
                    String option = sc.nextLine();
                    if (option.equalsIgnoreCase("y")) {
                        exitToAdd = false;
                    }
                }

            } else if (choice == 2) {
                showStudentList();
            } else if (choice == 6) {
                break;
            }
        }

    }


}
