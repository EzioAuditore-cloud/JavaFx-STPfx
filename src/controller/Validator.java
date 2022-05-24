package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Employee;
import model.Employees;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.InputException;


public class Validator extends Controller<Employees> implements Initializable{
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
    
    
    @FXML
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
    void handleAdd(ActionEvent event) throws IOException {
        String name = nameTxt.getText();
        String email = emailTxt.getText();
        String phone = phoneTxt.getText();
        String address = addressTxt.getText();
        String TFN = TFNTxt.getText();
        String type = job_typeTxt.getText();
        String errors="";
        if(!Pattern.matches("[A-Za-z]+\\s*[A-Za-z]*", name))
        {
            errors +="name";
        }
        if (!Pattern.matches("^[a-zA-Z0-9_-]+\\.[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", email)) {
            errors+="email";
        }
        if (!Pattern.matches("[0-9]{8}", phone)) {
            errors+="phone";
        }
        if (!Pattern.matches("\\d{3}[-]{1}\\d{3}", TFN)) {
            errors+="TFN";
        }
        
        if(!errors.isEmpty())
        {
            InputException e = new InputException(errors);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/view/error.png"));
            ViewLoader.showStage(e, "/view/exception.fxml", "Input Exception", stage);
            System.out.println(e.getMessage());
        }
        else
        {
            Employee newEmployee = new Employee(
                name,email,phone,address,TFN,type,
                Integer.parseInt(paid_hoursTxt.getText()),
                Double.parseDouble(hourly_rateTxt.getText())
            );
            model.addEmployee(newEmployee);
            System.out.println(newEmployee.getName() + " record has been created.");
        }       
    }

    @FXML
    void handleUpdate(ActionEvent event) throws IOException {
        String name = nameTxt.getText();
        String email = emailTxt.getText();
        String phone = phoneTxt.getText();
        String address = addressTxt.getText();
        String TFN = TFNTxt.getText();
        String type = job_typeTxt.getText();
        String errors="";
        if(!Pattern.matches("[A-Za-z]+\\s*[A-Za-z]*", name))
        {
            errors +="name";
        }
        if (!Pattern.matches("^[a-zA-Z0-9_-]+\\.[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", email)) {
            errors+="email";
        }
        if (!Pattern.matches("[0-9]{8}", phone)) {
            errors+="phone";
        }
        if (!Pattern.matches("\\d{3}[-]{1}\\d{3}", TFN)) {
            errors+="TFN";
        }
        
        if(!errors.isEmpty())
        {
            InputException e = new InputException(errors);
            ViewLoader.showStage(e, "/view/exception.fxml", "Input Exception", new Stage());
            System.out.println(e.getMessage());
        }
        else
        {
            Employee e = new Employee(name,email,phone,address,TFN,type,
            Integer.parseInt(paid_hoursTxt.getText()),
            Double.parseDouble(hourly_rateTxt.getText()));
            model.remove(model.getEmployee(nameTxt.getText()));
            model.addEmployee(e);
        }
        
    }

    @FXML
    void handleClose(ActionEvent event) {
        stage.close();
    }
}
