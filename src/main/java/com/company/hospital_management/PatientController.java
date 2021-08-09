package com.company.hospital_management;


import com.company.dbhelper.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PatientController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewPatients() {
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

            int patientId, age;
            String name;
            Patient patient = new Patient();
            while (rs.next()) {
                patientId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                patient.setId(patientId);
                patient.setName(name);
                patient.setAge(age);
                System.out.println(patientId + "\t " + name + "\t " + age + "\t ");
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
        System.out.print("name, age");
        System.out.print("Enter the field you want to edit: ");
        String field = scanner.next();
        System.out.print("Enter the updated value: ");
        String updatedValue = scanner.next();

        try {
            ps = DBConnection.getConnection().prepareStatement("UPDATE patients SET " + field +
                    " = " + updatedValue + " WHERE id = " + id);
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
            ps = DBConnection.getConnection().prepareStatement("DELETE FROM patient WHERE id= " + id);
            ps.execute();
            System.out.println("Successfully deleted patient.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
