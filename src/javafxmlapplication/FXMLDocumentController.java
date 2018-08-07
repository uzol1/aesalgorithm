/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author ujjwal
 */
public class FXMLDocumentController implements Initializable {
    AESAlgorithm aesAlgo;
    AESAlgorithm aesAlgo1;
   
    
    @FXML
    public Label label;
    
    @FXML
    public TextField dtext;

    @FXML
    public TextField etext;
    
      @FXML
    public TextField dkey;

    @FXML
    public TextField ekey;
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try{
            String ky=ekey.getText();
             aesAlgo = new AESAlgorithm(ky);
            String plainText=etext.getText();
           String encryptedText= aesAlgo.encrypt(plainText);
            dtext.setText(encryptedText);
        }catch (Exception ex){
       ex.printStackTrace();
       Logger.getLogger(AESAlgorithm.class.getName()).log(Level.SEVERE,null,ex);
       }
    }
 
    /**
     *
     * @param event
     */
    @FXML
    private void decryptbutton(ActionEvent event) {
        try{ 
             String ky1= dkey.getText();
            aesAlgo1= new AESAlgorithm(ky1);
        String encryptedText=dtext.getText();
        String plainText1= aesAlgo1.decrypt(encryptedText);
         dtext.setText(plainText1);
           }catch(Exception ex){
                ex.printStackTrace();
                Logger.getLogger(AESAlgorithm.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}


