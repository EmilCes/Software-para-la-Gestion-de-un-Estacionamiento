package sge.controladores;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;



public class FXMLAsignarEspaciosController implements Initializable {

    @FXML
    private AnchorPane apAsignarEspacios;
    @FXML
    private Label lbNumeroLugar;
    @FXML
    private Label lbNumeroPiso;
    @FXML
    private Label lbNumeroTarjeta;
    @FXML
    private Label lbNumeroCajon;
    @FXML
    private Label lbHoraEntrada;
    @FXML
    private Label lbFechaEntrada;
    @FXML
    private FontAwesomeIcon faIcon;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void llenarInformaciónPantalla(int numCajon, String numPiso, String fechaEntrada, String horaEntrada, String numTarjeta){
        String numCajonUnDigito = (numCajon < 10) ? "0" + numCajon : "" + numCajon; 
        if(numPiso.equals("Motos")){
            faIcon.setGlyphName("MOTORCYCLE");
            faIcon.setLayoutX(45);
        }
        
        lbNumeroLugar.setText(numCajonUnDigito);
        lbNumeroPiso.setText(numPiso);
        lbNumeroTarjeta.setText(numTarjeta);
        lbNumeroCajon.setText(numCajonUnDigito);
        lbHoraEntrada.setText(horaEntrada);
        lbFechaEntrada.setText(fechaEntrada);
    }


    @FXML
    private void clicBtnConfirmar(ActionEvent event) {
    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        AnchorPane apPadreAsignarEspacios = (AnchorPane) apAsignarEspacios.getParent();
        apPadreAsignarEspacios.getChildren().clear();
        try {
            FXMLLoader espaciosLoader = new FXMLLoader(getClass().getResource("/sge/vistas/FXMLEspacios.fxml"));
            AnchorPane espaciosPane = espaciosLoader.load();
            apPadreAsignarEspacios.getChildren().add(espaciosPane);
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
    }
    
}
