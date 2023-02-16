package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.sql.ResultSet;

public class user {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public void GetUserFromStorage(String user, String pass) {
        try {
            Connection databaseConnection = DriverManager
            .getConnection("jdbc:mysql://localhost/ppl_schema?user=root&password=spiderman");
            Statement userStatement = databaseConnection.createStatement();
            ResultSet results = userStatement.executeQuery("SELECT * FROM users WHERE username = '" + user + "' AND pas = '" + pass + "'");
            if (results.next()) {
                firstName = results.getString("first");
                lastName = results.getString("last");
                email = results.getString("email");
                username = results.getString("username");
                password = results.getString("pas");
            } else {
                System.out.println("User not found");
            }
            databaseConnection.close();
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }
    // READ

    public void AddUserToStorage() {
        try {
            Connection databaseConnection = DriverManager
            .getConnection("jdbc:mysql://localhost/ppl_schema?user=root&password=spiderman");

            Statement createStatement = databaseConnection.createStatement();
            StringBuilder sqlStringBuilder = new StringBuilder();
            Random rand = new Random();
            int randomNum = rand.nextInt((2000000000 - 1) + 1) + 1;
            sqlStringBuilder.append("INSERT INTO users VALUES (" + randomNum +  ", '");
            sqlStringBuilder.append(firstName);
            sqlStringBuilder.append("', '");
            sqlStringBuilder.append(lastName);
            sqlStringBuilder.append("', '");
            sqlStringBuilder.append(email);
            sqlStringBuilder.append("', '");
            sqlStringBuilder.append(username);
            sqlStringBuilder.append("', '");
            sqlStringBuilder.append(password);
            sqlStringBuilder.append("')");
            
            int rowsCreated = createStatement.executeUpdate(sqlStringBuilder.toString());

            databaseConnection.close();
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }
}
