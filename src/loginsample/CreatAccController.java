/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginsample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @FXML
    private TextField userName;
    @FXML
    private PasswordField pass, cPass;

    @FXML
    void make(ActionEvent event) {

        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            String data = userName.getText()+"+"+pass.getText()+"\n";

            File file = new File("src\\loginsample\\data.txt");

            // kiểm tra nếu file chưa có thì tạo file mới
            if (!file.exists()) {
                file.createNewFile();
            }
            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(),true);
            bw = new BufferedWriter(fw);
            bw.write(data);
            System.out.println("tao tai khoan thanh cong");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}




