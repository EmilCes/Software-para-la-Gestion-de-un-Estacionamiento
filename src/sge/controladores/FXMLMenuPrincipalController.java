package sge.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;



public class FXMLMenuPrincipalController implements Initializable {

    @FXML
    private AnchorPane apMenuPrincipal;
    @FXML
    private Button btnEspacios;
    @FXML
    private Button btnCobro;
    @FXML
    private Button btnTarjetas;
    @FXML
    private Button btnPrecios;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    private void cambiarPane(String path){
        try {
            FXMLLoader menuPrincipalLoader = new FXMLLoader(getClass().getResource(path));
            AnchorPane menuPrincipalPane = menuPrincipalLoader.load();
            apMenuPrincipal.getChildren().add(menuPrincipalPane);
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
    }
    
    private void resetearEstiloBotones(){
        btnEspacios.setDisable(false);
        btnCobro.setDisable(false);
        btnTarjetas.setDisable(false);
        btnPrecios.setDisable(false);
    }


    @FXML
    private void clicBtnAsignarEspacios(ActionEvent event) {
        apMenuPrincipal.getChildren().clear();
        resetearEstiloBotones();
        btnEspacios.setDisable(true);

        cambiarPane("/sge/vistas/FXMLEspacios.fxml");


    }

    @FXML
    private void clicBtnAdministrarCobro(ActionEvent event) {
        apMenuPrincipal.getChildren().clear();
        resetearEstiloBotones();
        btnCobro.setDisable(true);
    }

    @FXML
    private void clicBtnAdministrarTarjetas(ActionEvent event) {
        apMenuPrincipal.getChildren().clear();
        resetearEstiloBotones();
        btnTarjetas.setDisable(true);
    }

    @FXML
    private void clicBtnConfigurarPrecios(ActionEvent event) {
        apMenuPrincipal.getChildren().clear();
        resetearEstiloBotones();
        btnPrecios.setDisable(true);
        
        cambiarPane("/sge/vistas/FXMLConfigurarPrecios.fxml");
    }
    
}
