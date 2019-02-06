/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author thota
 */
public class CreatAccController {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField pass, cPass;

    @FXML
    void make(ActionEvent event) {//&&ablePass(pass.getText(),cPass.getText())

        if (ablePass(pass.getText(), cPass.getText())) {
            if (ableUser(userName.getText()))
             {
                BufferedWriter bw = null;
                FileWriter fw = null;

                try {
                    String data = userName.getText() + "+" + pass.getText() + "\n";

                    File file = new File("src\\loginsample\\data.txt");

                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fw = new FileWriter(file.getAbsoluteFile(), true);
                    bw = new BufferedWriter(fw);
                    bw.write(data);
                    bw.close();
                    FXMLDocumentController.stage.close();

                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
            else {
                Alert al=new Alert(Alert.AlertType.INFORMATION);
                al.setContentText("Tên đăng nhập đã được sử dụng");
                al.show();
            }
        }

    }

    @FXML
    void cancelClose(ActionEvent event) {
        FXMLDocumentController.stage.close();
    }

    public static boolean ableUser(String u) {
        try {
            File f = new File("src\\loginsample\\data.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            BufferedReader read = new BufferedReader(new FileReader(f));
            String str = read.readLine();
            while (str != null) {
                if (str.contains(u + "+")) {
                    return false;
                }
                str = read.readLine();
            }
            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static boolean ablePass(String p, String cp) {
        return p.equals(cp);
    }
}
