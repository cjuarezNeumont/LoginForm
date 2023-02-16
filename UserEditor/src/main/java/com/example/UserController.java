package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class UserController {
    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField password;


    @FXML
    private TextField logUser;
    @FXML
    private TextField logPass;

    @FXML
    private Label welcomLabel;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void submitForm() {        
        if (firstNameInput.getText().isEmpty() || lastNameInput.getText().isEmpty() || email.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()) {
            System.out.println("Please fill out all fields");
        } else if (firstNameInput.getText().contains(" ") || lastNameInput.getText().contains(" ") ) {
            System.out.println("Name has an illegal character (a space replace with _)");
        } else if (password.getText().length() < 8) {
            System.out.println("Password must be at least 8 characters");
        } else {
            System.out.println("Form submitted");
            createUser();
        }
    }

    @FXML
    private void login() {
            System.out.println("Form submitted");
            user user = new user();
            String loginPass = logPass.getText();
            String loginUser = logUser.getText();
            user.GetUserFromStorage(loginUser, loginPass);
            if (user.getUsername() != null) {
                welcomLabel.setText("Welcome " + user.getFirstName() + " " + user.getLastName());
            } else {
                System.out.println("User does not exist");
            }
        
    }

    @FXML
    private void createUser() {
        user user = new user();
        user.setFirstName(firstNameInput.getText());
        user.setLastName(lastNameInput.getText());
        user.setEmail(email.getText());
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.AddUserToStorage();
    }
}
