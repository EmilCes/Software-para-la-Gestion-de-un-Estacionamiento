package sge.controladores;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import sge.modelos.dao.EspacioDAO;
import sge.modelos.dao.FechaHoraTarjetaDAO;
import sge.modelos.dao.TarjetaDAO;
import sge.modelos.pojo.Espacio;
import sge.modelos.pojo.FechaHoraTarjeta;
import sge.modelos.pojo.Tarjeta;
import sge.utils.Utilidades;

public class FXMLCobrosController implements Initializable {

    @FXML
    private AnchorPane apAdministrarCobros;
    @FXML
    private Label lbTotal;
    @FXML
    private Label lbCostoHora;
    @FXML
    private Label lbNumeroHoras;
    @FXML
    private Label lbTotalHoras;
    @FXML
    private Label lbMulta;
    @FXML
    private Label lbCargoExtra;
    @FXML
    private TextField tfNumeroTarjeta;
    @FXML
    private Label lbSinTarjeta;
    @FXML
    private Label lbPiso;
    @FXML
    private Label lbCajon;
    @FXML
    private Label lbFechaEntrada;
    @FXML
    private Label lbHoraEntrada;
    @FXML
    private Label lbFechaSalida;
    @FXML
    private Label lbHoraSalida;
    @FXML
    private TextField tfCargoExtra;
    @FXML
    private Label lbErrorNumeroTarjeta;
    @FXML
    private Label lbErrorCargoExtra;
    @FXML
    private Label lbTipoVehiculo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        enviarConEnter();
    }

    @FXML
    private void clicBtnBuscarTarjeta(ActionEvent event) throws ParseException {
        try {
            cargarInformacionTarjeta();
        } catch (ParseException ex) {
            Utilidades.mostrarDialogoSimple("Error en la información",
                    "Hubo un error en la información, repórtelo al administrador del sistema.",
                    Alert.AlertType.ERROR);
        }

    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
    }

    @FXML
    private void clicBtnCobrar(ActionEvent event) {
    }

    @FXML
    private void clicBtnAñadirCargo(ActionEvent event) {
    }

    private Tarjeta validarNumeroTarjeta() {
        Tarjeta tarjeta = null;
        String numeroTarjeta = tfNumeroTarjeta.getText();
        int numTarjeta = -1;
        if (numeroTarjeta.isEmpty()) {
            lbErrorNumeroTarjeta.setText("Campo Necesario");
        } else {
            try {
                numTarjeta = Integer.parseInt(numeroTarjeta);
            } catch (NumberFormatException e) {
                lbErrorNumeroTarjeta.setText("Ingresar cantidad numerica");
            }
        }

        if (numTarjeta <= 250) {
            tarjeta = TarjetaDAO.buscarTarjeta(numTarjeta);
        } else {
            Utilidades.mostrarDialogoSimple("Error Tarjeta",
                    "La tarjeta que búsca no existe.",
                    Alert.AlertType.INFORMATION);
            tfNumeroTarjeta.clear();
        }

        return tarjeta;
    }

    private void cargarInformacionTarjeta() throws ParseException {
        Tarjeta tarjeta = validarNumeroTarjeta();
        if (tarjeta != null & tarjeta.getEstadoTarjeta().equals("En Uso")) {

            Espacio espacio = EspacioDAO.buscarEspacio(tarjeta.getIdCajon());
            FechaHoraTarjeta fechaHoraTarjeta = FechaHoraTarjetaDAO.buscarFechaHoraTarjeta(tarjeta.getIdFechaHoraTarjeta());

            SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            Date fechaHora = formatoFechaHora.parse(fechaHoraTarjeta.getFechaHoraEntrada());

            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
            
            String fechaEntrada = formatoFecha.format(fechaHora);
            String horaEntrada = formatoHora.format(fechaHora);

            lbTipoVehiculo.setText(espacio.getTipoVehiculo());
            lbPiso.setText(String.valueOf(espacio.getNumeroPiso()));
            lbCajon.setText(String.valueOf(espacio.getNumeroCajon()));
            lbFechaEntrada.setText(fechaEntrada);
            lbHoraEntrada.setText(horaEntrada);

        } else {
            Utilidades.mostrarDialogoSimple("Error Tarjeta",
                    "La tarjeta que búsca no esta en uso.", Alert.AlertType.INFORMATION);
        }

    }

    public void enviarConEnter() {
        tfNumeroTarjeta.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                lbErrorNumeroTarjeta.setText("");
                try {
                    cargarInformacionTarjeta();
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                    Utilidades.mostrarDialogoSimple("Error en la información",
                            "Hubo un error en la información, repórtelo al administrador del sistema.",
                            Alert.AlertType.ERROR);
                }
            }
        });

    }
    
    public void calcularTotal(){
        
    }

}
