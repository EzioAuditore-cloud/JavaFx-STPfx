package controller;

import au.edu.uts.ap.javafx.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.text.Text;
import model.Employee;
import model.Employees;
import model.InputException;

public class ErrorController  extends Controller<InputException> {
    
    @FXML
    private VBox ErrorBox;
    
    @FXML
    private Button OkayBtn;
    
    @FXML
    private Text nameError;

    @FXML
    private Text phoneError;

    @FXML
    private Text emailError;

    @FXML
    private Text TFNError;
  
    
    public void initialize() {
        System.out.println(model.getMessage().indexOf("name"));
        if (model.getMessage().indexOf("name")!=-1) {
            nameError.setVisible(true);
        }
        if (model.getMessage().indexOf("email")!=-1) {
            emailError.setVisible(true);
        }
        if (model.getMessage().indexOf("phone")!=-1) {
            phoneError.setVisible(true);
        }
        if (model.getMessage().indexOf("TFN")!=-1) {
            TFNError.setVisible(true);
        }
    }
    
    
    @FXML
    void handleOkay(ActionEvent event) {
        stage.close();
        
    }
    
}
