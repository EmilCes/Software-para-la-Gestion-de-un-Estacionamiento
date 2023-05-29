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
import javafx.stage.Stage;
import sge.utils.Utilidades;



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
    @FXML
    private Button btnInfoMenuPrincipal;


    
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
        cambiarPane("/sge/vistas/FXMLCobros.fxml");
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
    
    @FXML
    private void clicBtnCerrarSesion(ActionEvent event) {
        boolean cerrarSesion = Utilidades.mostrarDialogoConfirmacion("Cerrar Sesión", "¿Seguro que deseas salir?");
        if(cerrarSesion)
            irInicioSesion();
    }
    
    private void irInicioSesion(){
        Stage escenarioBase = (Stage) btnEspacios.getScene().getWindow();
        escenarioBase.setScene(Utilidades.inicializarEscena("vistas/FXMLInicioSesion.fxml"));
        Utilidades.centrarEscenario(escenarioBase);
        escenarioBase.setTitle("Inicio Sesíon");    
        escenarioBase.show();   
    }

    @FXML
    private void clicBtnInfoMenuPrincipal(ActionEvent event) {
    }
    
}
