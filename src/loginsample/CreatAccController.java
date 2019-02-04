/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author thota
 */
public class CreatAccController {
    @FXML private TextField userName;
    @FXML private PasswordField pass,cPass;
    @FXML
    private Label labelShow;
    
    @FXML
    void make(ActionEvent event) {
        
    }
    @FXML
    public void showAcc(ActionEvent e){
        labelShow.setText(userName.getText());
    }
    public static boolean able(){
        return true;
        
    }

}
