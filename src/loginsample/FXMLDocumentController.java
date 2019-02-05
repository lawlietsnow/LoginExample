/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author thota
 */
public class FXMLDocumentController {

    Account acc = new Account("1", "1");
    @FXML
    TextField user;
    @FXML
    PasswordField pass;

    @FXML
    public void log(ActionEvent e) {
        if (correct(user.getText(), pass.getText())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("thông báo:");
            alert.setContentText("Đăng nhập thành công");

            System.out.println("Login");
            alert.show();
        }
        else System.out.println("sai tk hoac mk");

    }
    @FXML
    Label labelShow;

    @FXML
    public void showAcc(ActionEvent e) {
    }

    @FXML
    public void creat(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("creatAcc.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean correct(String u, String p) {
        String s="";
        try {
            File f=new File("src\\loginsample\\data.txt");
            if(!f.exists()) f.createNewFile();
            BufferedReader read=new BufferedReader(new FileReader(f));
            String str=read.readLine();
            while(str!=null){
                if(str.equals(u+"+"+p))return true;
                str=read.readLine();
            }
            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
