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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;


public class EmployerController extends Controller<Employer> implements Initializable {
    @FXML
    private Button closeBtn;

    @FXML
    private TextField nameTxt;

    @FXML
    private Button selectBtn;

    @FXML
    private Button PAYGBtn;

    @FXML
    private TextField emailTxt;

    @FXML
    private Button STPBtn;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;
    
    @FXML
    private TableView<Employee> employees_table;

    @FXML
    private TableColumn<Employee, Integer> phoneCol;
    
    @FXML
    private TableColumn<Employee, String> emailCol;
 
    @FXML
    private TableColumn<Employee, String> nameCol;
    
    Employees e = new Employees();
    String sname;
    
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {     
        
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone")); 
        employees_table.setItems(e.getCurrentList());
        nameTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {              
                e.filterList(newValue, "???");
                nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
                emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
                phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone")); 
                employees_table.setItems(e.getCurrentList());
            }       
        });        
        emailTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {              
                e.filterList("???",newValue );
                nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
                emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
                phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone")); 
                employees_table.setItems(e.getCurrentList());
            }       
        });   
        
        employees_table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Employee>(){
            @Override
            public void changed(ObservableValue<? extends Employee> observable, Employee oldValue, Employee newValue) {
                if (newValue!=null) {
                    PAYGBtn.setDisable(false);
                    deleteBtn.setDisable(false);
                    sname = newValue.getName();
                }
            } 
        });
            
    }
     
 
    @FXML
    void handleAdd(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(e, "/view/addEmployee.fxml", "Add New Employee", stage);
    }


    @FXML
    void handleDelete(ActionEvent event) {
        e.remove(e.getEmployee(sname));
    }

    @FXML
    void handleSelect(ActionEvent event) {

    }

    @FXML
    void handlePAYG(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(e.getEmployee(sname), "/view/PAYG.fxml", sname+"Shwarz PAYG Report", stage);
    }

    @FXML
    void handleSTP(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/view/edit.png"));
        ViewLoader.showStage(new STP(), "/view/STP.fxml", sname+"STP Report", stage);
    }

    @FXML
    void handleClose(ActionEvent event) {
        stage.close();
    }
}
