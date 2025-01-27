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

            System.out.println("Name: " + students.getName());
            System.out.println("Roll no: " + students.getRollNo());
            System.out.println("Stream: " + students.getStream());
            System.out.println("Section: " + students.getSection());
            System.out.println("Age: " + students.getAge());

            System.out.println("--------------------------------------------");
            System.out.println();
        }
    }

    public boolean updateStudentData(Student newStudentData, int index) {
        boolean isUpdated = false;
        for (Student students : studentList) {
            if (newStudentData.getRollNo() == students.getRollNo()) {
                studentList.set(index, newStudentData);
                isUpdated = true;
                break;
            }
        }
        return isUpdated;
    }

    public void deleteStudentData(int index){
    studentList.remove(index);
    }


    public void menu() {
        System.out.println("==========*** IIT Student Management System ***==========");

        int choice = 0;
        while (true) {
            System.out.println("1]. Add Student \t\t\t\t 2].List All Student");
            System.out.println("3]. Find Student \t\t\t\t 4].Update Student");
            System.out.println("5]. Delete Student \t\t\t\t 6].Exit");
            System.out.print("Enter your Choice: ");
            System.out.println("--------------------------------------------");
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
            } else if (choice == 3) {
                System.out.println("Enter Student Roll No.");
                int rollNo = sc.nextInt();
                sc.nextLine();
                Student getStudent = null;
                for (Student students : studentList) {
                    if (students.getRollNo() == rollNo) {
                        getStudent = students;
                        break;
                    }
                }
                if (getStudent != null) {

                    System.out.println("Name: " + getStudent.getName());
                    System.out.println("Roll no: " + getStudent.getRollNo());
                    System.out.println("Stream: " + getStudent.getStream());
                    System.out.println("Section: " + getStudent.getSection());
                    System.out.println("Age: " + getStudent.getAge());
                } else {
                    System.out.println("Student data not found! or Enter correct roll no.");
                }
            } else if (choice == 4) {
                System.out.println("Enter Roll No to Update.");
                int rollNo = sc.nextInt();
                sc.nextLine();
                Student studentData = null;
                int index = 0;
                for (Student students : studentList) {
                    if (students.getRollNo() == rollNo) {
                        studentData = students;
                        index = studentList.indexOf(students);
                    }
                }

                if (studentData != null) {
                    System.out.println("1] Name: " + studentData.getName());
                    System.out.println("2] Stream: " + studentData.getStream());
                    System.out.println("3] Section: " + studentData.getSection());
                    System.out.println("4] Age: " + studentData.getAge());
                    System.out.println();
                    System.out.println("Enter Option to update.");
                    int option = sc.nextInt();
                    sc.nextLine();
                    String updatedValue = null;
                    int newAge = 0;
                    boolean isUpdated = false;
                    switch (option) {
                        case 1:
                            System.out.println("Enter Updated Name: ");
                            updatedValue = sc.nextLine();
                            studentData.setName(updatedValue);
                            isUpdated = updateStudentData(studentData, index);
                            if (isUpdated) {
                                System.out.println("Student data updated Successfully.");
                            } else {
                                System.out.println("Something went wrong.");
                            }
                            break;

                        case 2:
                            System.out.println("Enter Updated Stream: ");
                            updatedValue = sc.nextLine();
                            studentData.setStream(updatedValue);
                            isUpdated = updateStudentData(studentData, index);
                            if (isUpdated) {
                                System.out.println("Student data updated Successfully.");
                            } else {
                                System.out.println("Something went wrong.");
                            }
                            break;
                        case 3:
                            System.out.println("Enter Updated Section: ");
                            updatedValue = sc.nextLine();
                            studentData.setSection(updatedValue);
                            isUpdated = updateStudentData(studentData, index);
                            if (isUpdated) {
                                System.out.println("Student data updated Successfully.");
                            } else {
                                System.out.println("Something went wrong.");
                            }
                            break;
                        case 4:
                            System.out.println("Enter Updated Section: ");
                             newAge= sc.nextInt();
                             sc.nextLine();
                            studentData.setAge(newAge);
                            isUpdated = updateStudentData(studentData, index);
                            if (isUpdated) {
                                System.out.println("Student data updated Successfully.");
                            } else {
                                System.out.println("Something went wrong.");
                            }
                            break;

                    }


                }

            }else if(choice ==5){
                System.out.println("Enter Student Roll No.");
                int rollNo = sc.nextInt();
                sc.nextLine();
                deleteStudentData(rollNo-1);
                System.out.println("Student data deleted successfully");
            } else if (choice == 6) {
                break;
            }
        }

    }


}
