package com.carrental.cs4125.model;

import java.sql.*;

public class userAuth {
    public static void register(String name, String password, String email){
        String url = "jdbc:mysql://localhost:3306/cs4125";
        String user = "root";
        String pass = "";

        System.out.println("Connecting to database...");

        try(Connection connection = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Database connected");
            Statement stmt = null;
            stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO `user` (username,password,email) VALUE ('"+name+"','"+password+"','"+email+"')");
            System.out.println("Updated Database with user " + name);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }

    public static void main(String args[]){
        //register("Sean2", "seanfitz12", "fitzgibbonsean3@gmail.com");
        login("Sean2", "seanfitz12");
        System.out.println("Done");
    }

    public static void login(String name, String password){
        PreparedStatement ps;
        ResultSet rs;
        String username1 = name;
        String password1 = password;

        String query = "SELECT * FROM `user` WHERE `username` =? AND `password` =?";

        String url = "jdbc:mysql://localhost:3306/cs4125";
        String user = "root";
        String pass = "";

        //System.out.println("Connecting to database...");

        try(Connection connection = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Database connected");
            //Statement stmt = null;
            //stmt = connection.createStatement();
            ps = connection.prepareStatement(query);
            ps.setString(1, username1);
            ps.setString(2, password1);

            rs = ps.executeQuery();

            if(rs.next()) {
                System.out.println("User " + username1 + " logged in successfully!");
            } else {
                System.out.println("Login failed, please try again.");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }
}
