package controller;

import au.edu.uts.ap.javafx.Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Employee;


public class PaygController extends Controller<Employee>  {
    @FXML
    private Text GincomeTxt;

    @FXML
    private Text payrateTxt;

    @FXML
    private Text SuperrateTxt;

    @FXML
    private Button closeBtn;

    @FXML
    private Text TaxrateTxt;

    @FXML
    private Text PaidhoursTxt;

    @FXML
    private Text SuperannuationTxt;

    @FXML
    private Text NincomeTxt;

    @FXML
    private Text DeductionTxt; 

    @FXML
    public void initialize() {
        PaidhoursTxt.setText(""+model.getHours()+" hours");
        GincomeTxt.setText("$"+model.getIncome());
        payrateTxt.setText("$"+model.getPayPerHour());
        SuperrateTxt.setText(""+model.getSuperRate()+"%");
        TaxrateTxt.setText(model.getRate()+"%");
        SuperannuationTxt.setText("$"+model.getSuper());
        NincomeTxt.setText("$"+model.getNet());
        DeductionTxt.setText("$"+model.getDeduction());
    }
    
    @FXML
    void handleClose(ActionEvent event) {
        stage.close();
    }
}
