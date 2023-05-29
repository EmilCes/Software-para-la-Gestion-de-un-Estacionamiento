package sge.controladores;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import sge.modelos.dao.EspacioDAO;
import sge.modelos.dao.FechaHoraTarjetaDAO;
import sge.modelos.dao.TarjetaDAO;
import sge.modelos.pojo.FechaHoraTarjeta;
import sge.modelos.pojo.Tarjeta;
import sge.utils.Constantes;
import sge.utils.Utilidades;



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
    private Label lbFechaEntrada;
    @FXML
    private FontAwesomeIcon faIcon;

    private int numeroCajon;
    private int numeroCajonPiso;
    private int numeroPiso;
    private String horaEntrada;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void llenarInformaciónPantalla(int numCajon, String numPiso, String fechaEntrada, String numTarjeta){
        numeroCajon = numCajon;
        numeroCajonPiso = numCajon;
        if(numPiso.equals("Motos"))
            numeroPiso = 5;
        else
            numeroPiso = Integer.parseInt(numPiso);
        String numCajonUnDigito = (numCajon < 10) ? "0" + numCajon : "" + numCajon; 
        if(numPiso.equals("Motos")){
            faIcon.setGlyphName("MOTORCYCLE");
            faIcon.setLayoutX(45);
        }
        
        obtenerNumeroCajon();
        
        lbNumeroLugar.setText(numCajonUnDigito);
        lbNumeroPiso.setText(numPiso);
        lbNumeroTarjeta.setText(numTarjeta);
        lbNumeroCajon.setText(numCajonUnDigito);
        lbFechaEntrada.setText(fechaEntrada);
        lbNumeroTarjeta.setText(String.valueOf(numeroCajon));
    }


    @FXML
    private void clicBtnConfirmar(ActionEvent event) {
        asignarEspacio();
        Utilidades.mostrarDialogoSimple("Espacio Asignado",
                                        "Espacio Asignado Correctamente\n"
                                      + "\nNumero Piso: " + numeroPiso
                                      + "\nNumero Cajón: " + numeroCajonPiso
                                      + "\nHora Entrada: " + horaEntrada,
                                        Alert.AlertType.INFORMATION);
        regresarEspaciosDisponibles();
    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        regresarEspaciosDisponibles();
    }
    
    private void asignarEspacio(){
        String horaEntrada = obtenerFechaHoraActual();
        
        FechaHoraTarjeta fechaHoraTarjeta = new FechaHoraTarjeta();
        fechaHoraTarjeta.setFechaHoraEntrada(horaEntrada);        
        fechaHoraTarjeta.setIDTarjeta(numeroCajon);
        EspacioDAO.guardarAsignacion(fechaHoraTarjeta);
        
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setEstadoTarjeta(Constantes.EN_USO);
        tarjeta.setIdFechaHoraTarjeta(FechaHoraTarjetaDAO.obtenerIdFechaHoraTarjeta());
        tarjeta.setIdTarjeta(numeroCajon);
        TarjetaDAO.actualizarTarjeta(tarjeta);
    }
    
    private String obtenerFechaHoraActual(){
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String horaEntrada = LocalDateTime.now().minusHours(1).format(formatoHora).toString();
        this.horaEntrada = horaEntrada;
        return horaEntrada;
        
    }
    
    private void obtenerNumeroCajon(){
        switch(numeroPiso){
                case 2:
                    numeroCajon += 50;
                    break;
                case 3:
                    numeroCajon += 100;
                    break;
                case 4:
                    numeroCajon += 150;
                    break;
                case 5:
                    numeroCajon += 200;
                    break;    
            }
        System.out.println(numeroCajon);
    }
    
    private void regresarEspaciosDisponibles(){
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
