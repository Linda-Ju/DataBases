package com.company;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Connection to database");
        Connection connection = dbConn();

        PreparedStatement ps;
        ResultSet rs;
        try {
//            ps = connection.prepareStatement("INSERT INTO animals(id, name, sound) VALUES(5, 'wolf', 'awwwwoooo')");
//            ps.execute();
//            System.out.println("Successfully added animal");
            ps = connection.prepareStatement("SELECT * FROM animals WHERE name = 'wolf'");
            rs = ps.executeQuery();

           //Declare variables to hold the data you'll be getting from the result set
            int id;
            String name, sound;
            System.out.println("ID\t name\t sound\t");
            while(rs.next()){
                id = rs.getInt("id");
                name = rs.getString("name");
                sound = rs.getString("sound");

                System.out.println(id+"\t " + name + "\t " + sound + "\t ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection dbConn() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrun", "root", "Wsxcftfcxsw!2233");
            System.out.println("Database is connected successfully");
        } catch (SQLException e) {
//            System.out.println("Unable to connect to database");
            e.printStackTrace();
        }
        return connection;
    }
}
