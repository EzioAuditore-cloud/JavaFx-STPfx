package controller;

import javafx.fxml.FXML;
import au.edu.uts.ap.javafx.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;

public class LoginController extends Controller<Employers> {
    @FXML
    private Label incorrect;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField emailTxt;

    @FXML
    private Button okBtn;

    @FXML
    private TextField passwordTxt;
    
    public final Employers getEmployers() { return model; }
    
    @FXML
    public void initialize() {
        incorrect.setVisible(false);
    }

    @FXML
    void handleOK(ActionEvent event) throws Exception{
        String email = emailTxt.getText();
        String psd = passwordTxt.getText();
        if (getEmployers().hasEmployer(email, psd)) {
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/employer.png"));
            ViewLoader.showStage(new Employer(), "/view/Employer.fxml", "Session Admin "+getEmployers().getEmployer(email, psd).getName(), stage);
            this.stage.close();
        }
        else
            incorrect.setVisible(true);
    }
    
    @FXML
    void handleCancel(ActionEvent event) {
        stage.close();
    }
    
}
