package com.company.hospital_management.menu;

import com.company.hospital_management.controllers.PatientController;

import java.util.Scanner;

public class HospitalMenu {
    public static void hospitalMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("1. Get a patient by ID");
        System.out.println("2. Add a new patient");
        System.out.println("3. Edit a patient's details");
        System.out.println("4. Delete a patient");
        System.out.println("5. Assign doctor");
        System.out.println("6. Assign drug");
        System.out.println("7. Add drug");
        System.out.println("8. Add doctor");
        System.out.println("9. Enter diagnosis");

        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                PatientController.getPatientById();
                break;
            case 2:
                PatientController.addNewPatient();
                break;
            case 3:
                PatientController.editPatient();
                break;
            case 4:
                PatientController.deletePatient();
                break;
            case 5:
                PatientController.assignDoctor();
                break;
            case 6:
                PatientController.assignDrugs();
                break;
            case 7:
                PatientController.addNewDrug();
                break;
            case 8:
                PatientController.addNewDoctor();
                break;
            case 9:
                PatientController.enterDiagnosis();
                break;

            default:
                System.out.print("Invalid option selected");

        }
    }
}
