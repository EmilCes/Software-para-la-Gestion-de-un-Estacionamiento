package sge.controladores;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sge.modelos.dao.ConfiguracionPreciosDAO;
import sge.modelos.dao.EspacioDAO;
import sge.modelos.dao.FechaHoraTarjetaDAO;
import sge.modelos.dao.TarjetaDAO;
import sge.modelos.pojo.ConfiguracionPrecios;
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
    @FXML
    private Label lbTarjetaExtraviada;
    @FXML
    private Label lbTarjetaDañada;
    @FXML
    private CheckBox chbExtraviada;
    @FXML
    private CheckBox chbDañada;

    private ConfiguracionPrecios precios;
    private String fechaHoraEntrada;
    private String fechaHoraSalida;
    private float costoTotalHoras;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        enviarConEnter();
        precios = ConfiguracionPreciosDAO.obtenerUltimaConfiguracionPrecios();
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
        validarCargoExtra();
    }

    private void validarCargoExtra() {
        String cargoExtraStr = tfCargoExtra.getText();
        try {
            float cargoExtra = Float.parseFloat(cargoExtraStr);
            lbCargoExtra.setText(String.valueOf(cargoExtra));
            calcularTotal();
        } catch (NumberFormatException e) {
            lbErrorCargoExtra.setText("Ingresar cantidad numerica");

        }
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
            
            fechaHoraEntrada = fechaHoraTarjeta.getFechaHoraEntrada();
            SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
            Date fechaHora = formatoFechaHora.parse(fechaHoraEntrada);

            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

            String fechaEntrada = formatoFecha.format(fechaHora);
            String horaEntrada = formatoHora.format(fechaHora);

            lbTipoVehiculo.setText(espacio.getTipoVehiculo());
            lbPiso.setText(String.valueOf(espacio.getNumeroPiso()));
            lbCajon.setText(String.valueOf(espacio.getNumeroCajon()));
            lbFechaEntrada.setText(fechaEntrada);
            lbHoraEntrada.setText(horaEntrada);

            calcularFechaHoraSalida();
            cargarInformacionTicket();
            calcularTotal();
            
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

        tfCargoExtra.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                lbErrorCargoExtra.setText("");
                validarCargoExtra();
            }
        });

    }
    
    private void cargarInformacionTicket(){
        long horas = calcularCostoHoras();
        lbNumeroHoras.setText(String.valueOf(horas));
        
        if(lbTipoVehiculo.getText().equals("Automovil")){
            if(horas > 12)
                lbCostoHora.setText(String.valueOf(precios.getPrecioHoraEspecialCarro()));
            else
                lbCostoHora.setText(String.valueOf(precios.getPrecioHoraNormalCarro()));
        } else{
            if(horas > 12)
                lbCostoHora.setText(String.valueOf(precios.getPrecioHoraEspecialMoto()));
            else
                lbCostoHora.setText(String.valueOf(precios.getPrecioHoraNormalMoto()));
        }
        
        costoTotalHoras = Float.parseFloat(lbCostoHora.getText()) * Float.parseFloat(lbNumeroHoras.getText());
        
        lbTotalHoras.setText(String.valueOf(costoTotalHoras));
    }

    private void calcularTotal() {
        float costoTarjetaExtraviada = Float.parseFloat(lbTarjetaExtraviada.getText());
        float costoTarjetaDañada = Float.parseFloat(lbTarjetaDañada.getText());
        float costoCargoExtra = Float.parseFloat(lbCargoExtra.getText());
        float costoTotal = costoCargoExtra + costoTarjetaExtraviada + costoTarjetaDañada + costoTotalHoras;

        lbTotal.setText(String.valueOf(costoTotal));
    }
    
    private long calcularCostoHoras(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime fecha1 = LocalDateTime.parse(fechaHoraEntrada, formato);
        LocalDateTime fecha2 = LocalDateTime.parse(fechaHoraSalida, formato);
        Duration diferencia = Duration.between(fecha1, fecha2);
        long horas = diferencia.toHours();
        return horas;
        
    }

    private void calcularFechaHoraSalida() throws ParseException {
        String formatoFechaHora = "yyyy-MM-dd HH:mm:ss.S";
        String fechaHoraStr = obtenerFechaHoraActual();
        
        DateTimeFormatter formateadorEntrada = DateTimeFormatter.ofPattern(formatoFechaHora);
        LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraStr, formateadorEntrada);
        
        String formatoFecha = "dd/MM/yyyy";
        String formatoHora = "HH:mm";

        DateTimeFormatter formateadorFecha = DateTimeFormatter.ofPattern(formatoFecha);
        DateTimeFormatter formateadorHora = DateTimeFormatter.ofPattern(formatoHora);
        String fechaSalida = fechaHora.format(formateadorFecha);
        String horaSalida = fechaHora.format(formateadorHora);
              
        lbFechaSalida.setText(fechaSalida);
        lbHoraSalida.setText(horaSalida);
    }

    @FXML
    private void clicTarjetaExtraviada(MouseEvent event) {
        if (chbExtraviada.isSelected()) {
            lbTarjetaExtraviada.setText(String.valueOf(precios.getPrecioTarjetaExtraviada()));
            calcularTotal();
        } else {
            lbTarjetaExtraviada.setText("0.00");
        }
    }

    @FXML
    private void clicTarjetaDañada(MouseEvent event) {
        if (chbDañada.isSelected()) {
            lbTarjetaDañada.setText(String.valueOf(precios.getPrecioTarjetaDañada()));
            calcularTotal();
        } else {
            lbTarjetaDañada.setText("0.00");
        }
    }

    private String obtenerFechaHoraActual() {
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        fechaHoraSalida = LocalDateTime.now().minusHours(1).format(formatoHora).toString();
        return fechaHoraSalida;

    }

}
