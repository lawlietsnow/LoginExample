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

//        if (ableConfirmPass(pass.getText(), cPass.getText())) {
//            if (ableUser(userName.getText()))
//             {
//                if(ablePass(pass.getText())){
//                    BufferedWriter bw = null;
//                FileWriter fw = null;
//
//                try {
//                    String data = userName.getText() + "+" + pass.getText() + "\n";
//
//                    File file = new File("src\\loginsample\\data.txt");
//
//                    if (!file.exists()) {
//                        file.createNewFile();
//                    }
//                    fw = new FileWriter(file.getAbsoluteFile(), true);
//                    bw = new BufferedWriter(fw);
//                    bw.write(data);
//                    bw.close();
//                    FXMLDocumentController.stage.close();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//
//                }
//                }else{
//                    //pass ko hop le
//                }   
//            }
//            else {
//                Alert al=new Alert(Alert.AlertType.INFORMATION);
//                al.setContentText("Tên đăng nhập đã được sử dụng");
//                al.show();
//            }
//        }else{
//            //confirm sai
//        }
        Alert al;
        if (ableConfirmPass(pass.getText(), cPass.getText()) && ableUser(userName.getText()) && ablePass(pass.getText())) {
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
            al = new Alert(Alert.AlertType.INFORMATION);
            al.setContentText("Xác nhận mật khẩu sai");
            al.show();
        } else {
            al = new Alert(Alert.AlertType.ERROR);
            if (!ableConfirmPass(pass.getText(), cPass.getText())) {

                al.setContentText("Xác nhận mật khẩu sai");
                al.show();
            } else if (!ableUser(userName.getText())) {
                al.setContentText("Tên đăng nhập đã bị sử dụng");
                al.show();
            } else if (!ablePass(pass.getText())) {
                al.setContentText("Mật khẩu không hợp lệ");
                al.show();
            }
        }

    }

    @FXML
    void cancelClose(ActionEvent event) {
        FXMLDocumentController.stage.close();
    }

    public static boolean ableUser(String u) {
        if (u.length() < 2) {
            return false;
        }
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

    public static boolean ablePass(String p) {
        return p.length() >= 6;
    }

    public static boolean ableConfirmPass(String p, String cp) {
        return p.equals(cp);
    }
}
