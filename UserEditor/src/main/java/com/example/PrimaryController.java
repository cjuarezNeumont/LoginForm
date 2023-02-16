package com.example;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class PrimaryController {
    @FXML
    private void switchToSurveyForm() throws IOException {
        App.setRoot("surveyform");
    }
    
    @FXML
    private void switchToLoginForm() throws IOException {
        App.setRoot("loginform");
    }

}
