/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsample;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import allData.*;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author thota
 */
public class FXMLDocumentController {
    @FXML TextField user;
    @FXML PasswordField pass;
    @FXML
    public void log(ActionEvent e){
        if(correct(user.getText(),pass.getText())) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("thông báo:");
            alert.setContentText("Đăng nhập thành công");
            
        }
    }
    @FXML 
    public void creat(ActionEvent e){
        try {
            Parent root=FXMLLoader.load(getClass().getResource("creatAcc.fxml"));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean correct(String u,String p){
        for(Account acc:ListAcc.list){
            if(acc.user.equals(u)&&acc.pass.equals(p)) return true;
        }
        return false;
    }
}
