package sge.controladores;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;



public class FXMLEspaciosController implements Initializable {

    @FXML
    private AnchorPane apEspacios;
    @FXML
    private Pane apPiso1;
    @FXML
    private Pane apPiso2;
    @FXML
    private Pane apPiso3;
    @FXML
    private Pane apPiso4;
    @FXML
    private Pane apPisoMotos;
    @FXML
    private Button btnPiso1;
    @FXML
    private Button btnPiso2;
    @FXML
    private Button btnPiso3;
    @FXML
    private Button btnPiso4;
    @FXML
    private Button btnPisoMotos;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnPiso1.setDisable(true);
    }   
    
    private void resetearEstiloBotones(){
        btnPiso1.setDisable(false);
        btnPiso2.setDisable(false);
        btnPiso3.setDisable(false);
        btnPiso4.setDisable(false);
        btnPisoMotos.setDisable(false);
    }
    
    private void resetearVisibilidadPisos(){
        apPiso1.setVisible(false);
        apPiso2.setVisible(false);
        apPiso3.setVisible(false);
        apPiso4.setVisible(false);
        apPisoMotos.setVisible(false);
    }

    @FXML
    private void clicPnSeleccionarLugar(MouseEvent event) {
        Pane pnLugar = (Pane) event.getSource();
        Label lbNumeroCajon = (Label) pnLugar.getChildren().get(2);
        AnchorPane apPadreEspacios = (AnchorPane) apEspacios.getParent();
        
        String numeroPiso = pnLugar.getParent().getId().substring(6);
        int numeroCajon = Integer.parseInt( lbNumeroCajon.getText());
        String fechaEntrada = LocalDate.now().toString();
        String horaEntrada = LocalTime.now().toString();
        String numeroTarjeta = "123456";

        
        apPadreEspacios.getChildren().clear();
        try {
            FXMLLoader asignarEspaciosLoader = new FXMLLoader(getClass().getResource("/sge/vistas/FXMLAsignarEspacios.fxml"));
            AnchorPane asignarEspaciosPane = asignarEspaciosLoader.load();
            apPadreEspacios.getChildren().add(asignarEspaciosPane);
            FXMLAsignarEspaciosController asignarEspaciosControlador = asignarEspaciosLoader.getController();
            asignarEspaciosControlador.llenarInformaciónPantalla(numeroCajon, numeroPiso, fechaEntrada, horaEntrada, numeroTarjeta);
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
    }

    @FXML
    private void clicBtnPiso1(ActionEvent event) {
        resetearEstiloBotones();
        resetearVisibilidadPisos();
        btnPiso1.setDisable(true);
        apPiso1.setVisible(true);
        
    }

    @FXML
    private void clicBtnPiso2(ActionEvent event) {
        resetearEstiloBotones();
        resetearVisibilidadPisos();
        btnPiso2.setDisable(true);
        apPiso2.setVisible(true);
    }

    @FXML
    private void clicBtnPiso3(ActionEvent event) {
        resetearEstiloBotones();
        resetearVisibilidadPisos();
        btnPiso3.setDisable(true);
        apPiso3.setVisible(true);
    }

    @FXML
    private void clicBtnPiso4(ActionEvent event) {
        resetearEstiloBotones();
        resetearVisibilidadPisos();
        btnPiso4.setDisable(true);
        apPiso4.setVisible(true);
    }

    @FXML
    private void clicBtnPisoMoto(ActionEvent event) {
        resetearEstiloBotones();
        resetearVisibilidadPisos();
        btnPisoMotos.setDisable(true);
        apPisoMotos.setVisible(true);
    }
    
}
