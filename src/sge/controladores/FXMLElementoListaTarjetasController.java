package sge.controladores;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sge.modelos.pojo.Tarjeta;

public class FXMLElementoListaTarjetasController {
    private Tarjeta tarjeta;

    @FXML
    private Label lbIDTarjeta;

    @FXML
    private Label lbEstadoTarjeta;

    @FXML
    private Button btnVerDetalles;

    @FXML
    void mostrarDetallesTarjeta(ActionEvent event) {
        
    }

    public void cargarTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
        lbIDTarjeta.setText(String.valueOf(tarjeta.getIdTarjeta()));
        lbEstadoTarjeta.setText(tarjeta.getEstadoTarjeta());
    }
    
    public void cambiarPane(String path){

    }   
}
