package com.company.student_management.controllers;

import com.company.dbhelper.DBConnection;
import com.company.student_management.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewStudents() {
        // Prompt the user for data
        System.out.print("Enter student's name: ");
        String name = scanner.next();

        System.out.print("Enter student's age: ");
        int age = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("INSERT INTO students(name, age)"
                    + "VALUES('" + name + "'," + age + ")");
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Student getStudentById() {
        // Prompt the user to enter id of the student they want to retrieve
        System.out.print("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("SELECT * FROM students WHERE id = " + id);
            rs = ps.executeQuery();

            int studentId, age;
            String name;
            Student student = new Student();
            while (rs.next()) {
                studentId = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setId(studentId);
                student.setName(name);
                student.setAge(age);
                System.out.println(studentId + "\t " + name + "\t " + age + "\t ");
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void editStudent() {
        System.out.print("Enter student's id: ");
        int id = scanner.nextInt();
        System.out.print("name, age");
        System.out.print("Enter the field you want to edit: ");
        String field = scanner.next();
        System.out.print("Enter the updated value: ");
        String updatedValue = scanner.next();

        try {
            ps = DBConnection.getConnection().prepareStatement("UPDATE students SET " + field +
                    " = " + updatedValue + " WHERE id = " + id);
            ps.execute();
            System.out.println("Successfully updated student.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter student's id: ");
        int id = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("DELETE FROM students WHERE id= " + id);
            ps.execute();
            System.out.println("Successfully deleted student.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addStudentScore() {
        System.out.print("Enter student's id: ");
        int id = scanner.nextInt();
        System.out.print("Enter Math score: ");
        int mathScore = scanner.nextInt();
        System.out.print("Enter English score: ");
        int englishScore = scanner.nextInt();


        try {
            ps = DBConnection.getConnection().prepareStatement("INSERT INTO scores(Mathematics, English, student_id) " +
                    "VALUES(" + mathScore + ", " + englishScore + ", " + id + ")");
            ps.execute();
            System.out.println("Successfully added score.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void removeStudentScore() {
        System.out.print("Enter student's id: ");
        int id = scanner.nextInt();
        System.out.print("Math, English");
        System.out.print("Enter the subject: ");
        String subject = scanner.next();

        try {
            ps = DBConnection.getConnection().prepareStatement("UPDATE scores SET " + subject +
                    " = 0 WHERE id = " + id);
            ps.execute();
            System.out.println("Successfully removed score.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void editStudentScore() {
        System.out.print("Enter student's id: ");
        int id = scanner.nextInt();
        System.out.print("Math, English");
        System.out.print("Enter the subject: ");
        String subject = scanner.next();
        System.out.print("Enter the updated score: ");
        int updatedScore = scanner.nextInt();

        try {
            ps = DBConnection.getConnection().prepareStatement("UPDATE scores SET " + subject +
                    " = " + updatedScore + " WHERE id = " + id);
            ps.execute();
            System.out.println("Successfully updated score.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
