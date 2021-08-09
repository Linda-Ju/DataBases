package com.company.student_management.menu;

import com.company.student_management.controllers.StudentController;

import java.util.Scanner;

public class Menu {
    public static void menu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("1. Get a student by ID");
        System.out.println("2. Add a new student");
        System.out.println("3. Edit a student's details");
        System.out.println("4. Delete a student");
        System.out.println("5. Add a new score");
        System.out.println("6. Edit a score");
        System.out.println("7. Delete a score");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch(option){
            case 1 :
                StudentController.getStudentById();
                break;
            case 2 :
                StudentController.addNewStudents();
                break;
            case 3 :
                StudentController.editStudent();
                break;
            case 4 :
                StudentController.deleteStudent();
                break;
            case 5 :
                StudentController.addStudentScore();
                break;
            case 6 :
                StudentController.editStudentScore();
                break;
            case 7 :
                StudentController.removeStudentScore();
                break;
            default:
                System.out.print("Invalid option selected");

        }
    }
}
