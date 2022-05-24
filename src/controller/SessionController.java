package controller;

import model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Session;
import javafx.stage.*;
import au.edu.uts.ap.javafx.*;
import javafx.scene.image.Image;


public class SessionController extends Controller<Session> {
   
    @FXML
    private Button loginBtn;

    @FXML
    private Button exitBtn;


    @FXML
    void handleLogin(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/view/book.png"));
        ViewLoader.showStage(new Employers(), "/view/login.fxml", "Sign in", stage);
    }

    @FXML
    void handleExit(ActionEvent event) {
        stage.close();
    }

}
