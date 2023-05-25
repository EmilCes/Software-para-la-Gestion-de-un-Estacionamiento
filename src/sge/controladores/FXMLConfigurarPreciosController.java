/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sge.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sge.utils.Utilidades;

/**
 * FXML Controller class
 *
 * @author kirbithalbertocubillashernandez
 */
public class FXMLConfigurarPreciosController implements Initializable {

    @FXML
    private AnchorPane apConfigurarPrecios;
    @FXML
    private Button btnGuardarPrecios;
    @FXML
    private Button btnInfoTarjetaDamage;
    @FXML
    private Button btnInfoTarjetaExtraviada;
    @FXML
    private Button btnInfoPrecioNormal;
    @FXML
    private Button btnInfoPrecioEspecial;
    @FXML
    private TextField tfPrecioNormal;
    @FXML
    private TextField tfTarjetaDamage;
    @FXML
    private TextField tfTarjetaExtraviada;
    @FXML
    private TextField tfPrecioEspecial;
    @FXML
    private Label lbErrorTarjetaDamage;
    @FXML
    private Label lbErrorTarjetaExtraviada;
    @FXML
    private Label lbErrorPrecioNormal;
    @FXML
    private Label lbErrorPrecioEspecial;
    @FXML
    private Label lbErrorPrecioEspecialMoto;
    @FXML
    private Label lbErrorPrecioNormalMoto;
    @FXML
    private Button btnInfoPrecioEspecialMoto;
    @FXML
    private Button btnInfoPrecioNormalMoto;
    @FXML
    private TextField tfPrecioEspecialMoto;
    @FXML
    private TextField tfPrecioNormalMoto;
    @FXML
    private Pane paneConfigurarPrecios;
    @FXML
    private Pane paneContraseñaAdmin;
    @FXML
    private PasswordField lbContraseñaAdmin;
    @FXML
    private Button btnInfoContraseñaAdmin;
    @FXML
    private Label lbErrorContraseñaAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicBtnGuardarPrecios(ActionEvent event) {
        lbErrorPrecioNormal.setText("");
        lbErrorPrecioEspecial.setText("");
        lbErrorTarjetaDamage.setText("");
        lbErrorTarjetaExtraviada.setText("");
        validarCampos();
    }

    @FXML
    private void btnClicEntrarAdmin(ActionEvent event) {
        lbErrorContraseñaAdmin.setText("");
        if(validarContraseñaAdmin()){
            paneContraseñaAdmin.setVisible(false);
            paneConfigurarPrecios.setVisible(true);
        }
    }
    
    @FXML
    private void clicBtnInfoTarjetaDamage(ActionEvent event) {
        Utilidades.mostrarDialogoSimple("Informacion tarjeta dañada",
                "Multa monetaria por daño completo o parcial de la tarjeta del estacionamiento",
                Alert.AlertType.INFORMATION);
    }

    @FXML
    private void clicBtnInfoTarjetaExtraviada(ActionEvent event) {
        Utilidades.mostrarDialogoSimple("Informacion tarjeta extraviada",
                "Multa monetaria por extravío de la tarjeta del estacionamiento",
                Alert.AlertType.INFORMATION);
    }

    @FXML
    private void clicBtnInfoPrecioNormal(ActionEvent event) {
        Utilidades.mostrarDialogoSimple("Informacion precio normal - Vehiculos",
                "Precio por cada hora en el estacionamiento para automoviles", 
                Alert.AlertType.INFORMATION);
    }

    @FXML
    private void clicBtnInfoPrecioEspecial(ActionEvent event) {
        Utilidades.mostrarDialogoSimple("Informacion precio especial - Vehiculos",
                "Precio por cada hora en el estacionamiento para automoviles cuando su estancia ha rebasado las 12 horas", 
                Alert.AlertType.INFORMATION);
    }
    
    @FXML
    private void clicBtnInfoPrecioEspecialMoto(ActionEvent event) {
        Utilidades.mostrarDialogoSimple("Informacion precio especial - Motocicletas",
                "Precio por cada hora en el estacionamiento para motocicletas cuando su estancia ha rebasado las 12 horas", 
                Alert.AlertType.INFORMATION);
    }

    @FXML
    private void clicBtnInfoPrecioNormalMoto(ActionEvent event) {
        Utilidades.mostrarDialogoSimple("Informacion precio normal - Motocicletas",
                "Precio por cada hora en el estacionamiento para motocicletas", 
                Alert.AlertType.INFORMATION);
    }
    
    @FXML
    private void clicBtnInfoContraseñaAdmin(ActionEvent event) {
        Utilidades.mostrarDialogoSimple("Contraseña de administrador",
                "Para poder configurar los precios, ingresa la contraseña de administrador",
                Alert.AlertType.INFORMATION);
    }
    
    
    private boolean validarContraseñaAdmin(){
        String contraseñaAdmin = lbContraseñaAdmin.getText();
        if (contraseñaAdmin.equals("123456")){
            return true;
        }
        if (contraseñaAdmin.isEmpty()){
            lbErrorContraseñaAdmin.setText("Ingresar contraseña!");
            return false;
        }else{
            lbErrorContraseñaAdmin.setText("Contraseña Incorrecta");
            return false;
        }
    }
    
    private void validarCampos(){
        String precioNormal = tfPrecioNormal.getText();
        String precioEspecial = tfPrecioEspecial.getText();
        String precioNormalMoto = tfPrecioNormalMoto.getText();
        String precioEspecialMoto = tfPrecioEspecialMoto.getText();
        String tarjetaDamage = tfTarjetaDamage.getText();
        String tarjetaExtraviada = tfTarjetaExtraviada.getText();
        
         if (precioNormal.isEmpty()) {
             lbErrorPrecioNormal.setText("Campo Necesario");
        }else{
             try {
                Double.parseDouble(precioNormal);
                } catch (NumberFormatException e) {
                 lbErrorPrecioNormal.setText("Ingresar cantidad numerica");
                }
         }
         
         if (precioEspecial.isEmpty()) {
             lbErrorPrecioEspecial.setText("Campo Necesario");
        }else{
             try {
                Double.parseDouble(precioEspecial);
                } catch (NumberFormatException e) {
                 lbErrorPrecioEspecial.setText("Ingresar cantidad numerica");
                }
         }
         
         if (precioNormalMoto.isEmpty()) {
             lbErrorPrecioNormalMoto.setText("Campo Necesario");
        }else{
             try {
                Double.parseDouble(precioNormalMoto);
                } catch (NumberFormatException e) {
                 lbErrorPrecioNormalMoto.setText("Ingresar cantidad numerica");
                }
         }
         
         if (precioEspecialMoto.isEmpty()) {
             lbErrorPrecioEspecialMoto.setText("Campo Necesario");
        }else{
             try {
                Double.parseDouble(precioEspecialMoto);
                } catch (NumberFormatException e) {
                 lbErrorPrecioEspecialMoto.setText("Ingresar cantidad numerica");
                }
         }
         
         if (tarjetaDamage.isEmpty()) {
             lbErrorTarjetaDamage.setText("Campo Necesario");
        }else{
             try {
                Double.parseDouble(tarjetaDamage);
                } catch (NumberFormatException e) {
                 lbErrorTarjetaDamage.setText("Ingresar cantidad numerica");
                }
         }
         
         if (tarjetaExtraviada.isEmpty()) {
             lbErrorTarjetaExtraviada.setText("Campo Necesario");
        }else{
             try {
                Double.parseDouble(tarjetaExtraviada);
                } catch (NumberFormatException e) {
                lbErrorTarjetaExtraviada.setText("Ingresar cantidad numerica");
                } 
         }
    }



    
}
