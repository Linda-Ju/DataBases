package com.company.hospital_management.controllers;


import com.company.dbhelper.DBConnection;
import com.company.hospital_management.Patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PatientController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewPatient() {
        System.out.print("Enter patient's name: ");
        String name = scanner.next();

        System.out.print("Enter patient's age: ");
        int age = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("INSERT INTO patients(name, age)"
                    + "VALUES('" + name + "'," + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Patient getPatientById() {
        System.out.print("Enter the id of the patient: ");
        int id = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("SELECT * FROM patients WHERE id = " + id);
            rs = ps.executeQuery();

            int patientId, age, doctorID, drugID;
            String name, diagnosis;
            Patient patient = new Patient();
            while (rs.next()) {
                patientId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                doctorID = rs.getInt("doctor");
                drugID = rs.getInt("drug_assigned");
                diagnosis = rs.getString("diagnosis");
                patient.setId(patientId);
                patient.setName(name);
                patient.setAge(age);
                patient.setDoctorID(doctorID);
                patient.setDrugID(drugID);
                patient.setDiagnosis(diagnosis);
                System.out.println(patientId + "\t " + name + "\t " + age + "\t "
                        + doctorID + "\t " + drugID + "\t " + drugID + "\t ");
            }
            return patient;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void editPatient() {
        System.out.print("Enter patient's id: ");
        int id = scanner.nextInt();
        System.out.print("Enter the field you want to edit: ");
        System.out.println("name, age");
        String field = scanner.next();
        System.out.print("Enter the updated value: ");
        String updatedValue = scanner.next();

        try {
            ps = DBConnection.getConnection().prepareStatement("UPDATE patients SET " + field +
                    " = '" + updatedValue + "' WHERE id = " + id);
            ps.execute();
            System.out.println("Successfully updated patient.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePatient() {
        System.out.print("Enter patient's id: ");
        int id = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("DELETE FROM patients WHERE id= " + id);
            ps.execute();
            System.out.println("Successfully deleted patient.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void assignDoctor() {
        System.out.print("Enter patient's id: ");
        int id = scanner.nextInt();
        System.out.print("Enter doctor's id: ");
        int doctorID = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("UPDATE patients SET doctor=' " + doctorID +
                    "' WHERE id='" + id + "';");
            ps.execute();
            System.out.println("Successfully assigned doctor.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void assignDrugs() {
        System.out.print("Enter patient's id: ");
        int id = scanner.nextInt();
        System.out.print("Enter drug you would like to assign: ");
        int drugID = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("UPDATE patients SET drug_assigned=' " + drugID +
                    "' WHERE id='" + id + "';");
            ps.execute();
            System.out.println("Successfully assigned drug.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean addNewDrug() {
        System.out.print("Enter name of the drug name: ");
        String name = scanner.next();

        try {
            ps = DBConnection.getConnection().prepareStatement("INSERT INTO drugs(name)"
                    + "VALUES('" + name + "'" + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addNewDoctor() {
        System.out.print("Enter doctor's name: ");
        String name = scanner.next();

        try {
            ps = DBConnection.getConnection().prepareStatement("INSERT INTO doctors(name)"
                    + "VALUES('" + name + "'" + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void enterDiagnosis() {
        System.out.print("Enter patient's id: ");
        int id = scanner.nextInt();
        System.out.print("Enter diagnosis: ");
        String diagnosis = scanner.next();

        try {
            ps = DBConnection.getConnection().prepareStatement("UPDATE patients SET diagnosis=' " + diagnosis +
                    "' WHERE id='" + id + "';");
            ps.execute();
            System.out.println("Successfully entered diagnosis.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
