package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.*;


public class StpController extends Controller<STP>{
    @FXML
    private TableView<Report> reportTable;
    
    @FXML
    private TableColumn<Report, Double> taxCol;

    @FXML
    private TableColumn<model.Report, Double> superCol;

    @FXML
    private TableColumn<model.Report, String> nameCol;  

    @FXML
    private TableColumn<Report, Double> netCol;

    @FXML
    private TableColumn<Report, Double> wageCol;
    
    @FXML
    private Text Ttax;

    @FXML
    private Text bas;

    @FXML
    private Text Tsuper;

    @FXML
    private Text Twages;

    @FXML
    private Button closeBtn;

    @FXML
    private Text Tnet;

    

    @FXML
    public void initialize(){
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        wageCol.setCellValueFactory(new PropertyValueFactory<>("wages"));
        taxCol.setCellValueFactory(new PropertyValueFactory<>("tax")); 
        netCol.setCellValueFactory(new PropertyValueFactory<>("net"));
        superCol.setCellValueFactory(new PropertyValueFactory<>("superannuation"));
        reportTable.setItems(model.reports());
        
        bas.setText(""+model.getBas());
        Twages.setText(""+model.getTotalWages());
        Ttax.setText(""+model.getTotalTax());
        Tnet.setText(""+model.getTotalNet());
        Tsuper.setText(""+model.getTotalSuper());
    }
    
    @FXML 
    void handleClose(ActionEvent event) {
        stage.close();
    }
}
