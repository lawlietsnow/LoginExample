/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import allData.*;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author thota
 */
public class CreatAccController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML private TextField userName;
    @FXML private PasswordField pass,cPass;


    @FXML
    void make(ActionEvent event) {
        if(pass.getText().equals(cPass.getText())&&!trungAcc(userName.getText()))
        ListAcc.list.add(new Account(userName.getText(),pass.getText()));
        ListAcc.list.add(new Account("1","1"));
    }

    public static boolean trungAcc(String user){
        for(Account acc:ListAcc.list){
            if(acc.user.equals(user)) return true;
        }
        return false;
    }

}
