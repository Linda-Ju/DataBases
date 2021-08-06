package com.company.student_management.controllers;

import com.company.student_management.dbhelper.DBConnection;
import com.company.student_management.login.Login;
import com.company.student_management.objects.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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

    public static Student getStudentId() {
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
            }

            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addStudentScore() {
        System.out.print("Enter the student's id: ");
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

}
