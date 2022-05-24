package controller;

import javafx.fxml.FXML;
import model.*;
import au.edu.uts.ap.javafx.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeController extends Controller<Employees> implements Initializable{
    @FXML
    private TextField phoneTxt;

    @FXML
    private TextField addressTxt;

    @FXML
    private TextField TFNTxt;

    @FXML
    private TextField paid_hoursTxt;

    @FXML
    private TextField hourly_rateTxt;

    @FXML
    private TextField job_typeTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private Button updateBtn1;

    @FXML
    private Button closeBtn2;

    @FXML
    private Button addBtn;
    
    
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateBtn1.setDisable(true);
        nameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {              
                for(Employee e:model.getCurrentList()){
                    if(newValue.equals(e.getName()) && !newValue.isEmpty())
                    {
                        updateBtn1.setDisable(false);
                        break;
                    }        
                }                
            }       
        });
    }
    
    @FXML
    void handleAdd(ActionEvent event) {
        String name = nameTxt.getText();
        String email = emailTxt.getText();
        String phone = phoneTxt.getText();
        String address = addressTxt.getText();
        String TFN = TFNTxt.getText();
        String type = job_typeTxt.getText();
        Employee newEmployee = new Employee(
                name,email,phone,address,TFN,type,
                Integer.parseInt(paid_hoursTxt.getText()),
                Double.parseDouble(hourly_rateTxt.getText())
        );
        model.addEmployee(newEmployee);
        System.out.println(newEmployee.getName() + " record has been created.");
        for (Employee employee : model.getCurrentList()) {
            System.out.println(employee.getEmail());
        }
    }

    @FXML
    void handleUpdate(ActionEvent event) {
        String name = nameTxt.getText();
        String email = emailTxt.getText();
        String phone = phoneTxt.getText();
        String address = addressTxt.getText();
        String TFN = TFNTxt.getText();
        String type = job_typeTxt.getText();
        Employee e = new Employee(name,email,phone,address,TFN,type,
                Integer.parseInt(paid_hoursTxt.getText()),
                Double.parseDouble(hourly_rateTxt.getText()));
        model.remove(model.getEmployee(nameTxt.getText()));
        model.addEmployee(e);
    }

    @FXML
    void handleClose(ActionEvent event) {
        stage.close();
    }
}
