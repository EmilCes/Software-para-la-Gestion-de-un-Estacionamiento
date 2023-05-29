
package sge.controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sge.modelos.dao.ConfiguracionPreciosDAO;
import sge.modelos.dao.InicioSesionDAO;
import sge.modelos.pojo.ConfiguracionPrecios;
import sge.modelos.pojo.ConfiguracionPreciosRespuesta;
import sge.modelos.pojo.Usuario;
import sge.utils.Constantes;
import sge.utils.Utilidades;




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
    private Button btnInfoPrecioEspecialMoto;
    @FXML
    private Button btnInfoPrecioNormalMoto;
    @FXML
    private Button btnInfoContraseñaAdmin;
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
    private TextField tfPrecioEspecialMoto;
    @FXML
    private TextField tfPrecioNormalMoto;
    @FXML
    private Pane paneConfigurarPrecios;
    @FXML
    private Pane paneContraseñaAdmin;
    @FXML
    private Label lbErrorContraseñaAdmin;
    @FXML
    private PasswordField tfContraseñaAdmin;
    @FXML
    private Button btnHistoial;
    @FXML
    private TableView<ConfiguracionPrecios> tvHistorialPrecios;
    @FXML
    private Pane paneHistorialPrecios;
    @FXML
    private Button btnBack;
    @FXML
    private TableColumn colIDPrecio;
    @FXML
    private TableColumn colHoraNormalCarro;
    @FXML
    private TableColumn colHoraEspecialCarro;
    @FXML
    private TableColumn colHoraNormalMoto;
    @FXML
    private TableColumn colHoraEspecialMoto;
    @FXML
    private TableColumn colTarjetaDañada;
    @FXML
    private TableColumn colTarjetaExtraviada;
    
    private ObservableList<ConfiguracionPrecios> configuracionesPrecios;
    @FXML
    private Pane paneGraficas;
    @FXML
    private LineChart<?, ?> grafHoraNormalCarro;
    @FXML
    private LineChart<?, ?> grafHoraNormalMoto;
    @FXML
    private LineChart<?, ?> grafTarjetaExtraviada;
    @FXML
    private LineChart<?, ?> grafTarjetaDañada;
    @FXML
    private LineChart<?, ?> grafHoraEspecialMoto;

   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        enviarConEnter();
        configurarTabla();
        try{
            mostrarConfiguracion();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @FXML
    private void clicBtnGuardarPrecios(ActionEvent event) {
        lbErrorPrecioNormal.setText("");
        lbErrorPrecioEspecial.setText("");
        lbErrorTarjetaDamage.setText("");
        lbErrorTarjetaExtraviada.setText("");
        lbErrorPrecioEspecialMoto.setText("");
        lbErrorPrecioNormalMoto.setText("");
        if(validarCampos()){
              ConfiguracionPrecios configuracionPrecios = new ConfiguracionPrecios();
              configuracionPrecios.setPrecioHoraNormalCarro(Double.parseDouble(tfPrecioNormal.getText()));
              configuracionPrecios.setPrecioHoraEspecialCarro(Double.parseDouble(tfPrecioEspecial.getText()));
              configuracionPrecios.setPrecioHoraNormalMoto(Double.parseDouble(tfPrecioNormalMoto.getText()));
              configuracionPrecios.setPrecioHoraEspecialMoto(Double.parseDouble(tfPrecioEspecialMoto.getText()));
              configuracionPrecios.setPrecioTarjetaDañada(Double.parseDouble(tfTarjetaDamage.getText()));
              configuracionPrecios.setPrecioTarjetaExtraviada(Double.parseDouble(tfTarjetaExtraviada.getText()));
              guardarConfiguracion(configuracionPrecios);
        }
    }
    
    private void mostrarConfiguracion() {
        ConfiguracionPrecios mostrarConfiguracionPrecios = ConfiguracionPreciosDAO.obtenerUltimaConfiguracionPrecios();
        tfPrecioNormal.setText(String.valueOf(mostrarConfiguracionPrecios.getPrecioHoraNormalCarro()));
        tfPrecioEspecial.setText(String.valueOf(mostrarConfiguracionPrecios.getPrecioHoraEspecialCarro()));
        tfPrecioNormalMoto.setText(String.valueOf(mostrarConfiguracionPrecios.getPrecioHoraNormalMoto()));
        tfPrecioEspecialMoto.setText(String.valueOf(mostrarConfiguracionPrecios.getPrecioHoraEspecialMoto()));
        tfTarjetaDamage.setText(String.valueOf(mostrarConfiguracionPrecios.getPrecioTarjetaDañada()));
        tfTarjetaExtraviada.setText(String.valueOf(mostrarConfiguracionPrecios.getPrecioTarjetaExtraviada()));
        System.out.println(mostrarConfiguracionPrecios.getPrecioHoraEspecialCarro());
                                                      
    }   
 

    private void guardarConfiguracion(ConfiguracionPrecios configuracionPrecios){
        int codigoRespuesta = ConfiguracionPreciosDAO.guardarConfiguracionPrecios(configuracionPrecios);
        switch(codigoRespuesta){
            case Constantes.ERROR_CONEXION:
                Utilidades.mostrarDialogoSimple("Error de Conexión", 
                                                "La configuración no pudo ser guardado en la base de datos debido a un error en su conexión", 
                                                Alert.AlertType.ERROR);
                break;
            case Constantes.ERROR_CONSULTA:
                Utilidades.mostrarDialogoSimple("Error en la información", 
                                                "La información de la configuración no puede ser guardada, verifique su información", 
                                                Alert.AlertType.WARNING);
                break;
            case Constantes.OPERACION_EXITOSA:
                Utilidades.mostrarDialogoSimple("Alumno registrado", 
                                                "La configuracion de precios fue guardada correctamente", 
                                                Alert.AlertType.INFORMATION);
                break;
        }
        
    }
    
    @FXML
    private void btnClicEntrarAdmin(ActionEvent event) {
        lbErrorContraseñaAdmin.setText("");
        validarContraseñaAdmin();
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

    private void validarContraseñaAdmin() {
        String contraseñaAdmin = tfContraseñaAdmin.getText();
        Usuario usuario = InicioSesionDAO.verificarAdminSesion(contraseñaAdmin);
        
        if (contraseñaAdmin.equals(usuario.getContraseña())) {          
            paneContraseñaAdmin.setDisable(true);
            paneContraseñaAdmin.setVisible(false);
            paneConfigurarPrecios.setDisable(false);
            paneConfigurarPrecios.setVisible(true);
            return;
        }
        if (contraseñaAdmin.isEmpty()) {
            lbErrorContraseñaAdmin.setText("Ingresar contraseña!");
            return;
        } else {
            lbErrorContraseñaAdmin.setText("Contraseña Incorrecta");
            return;
        }
    }

    private boolean validarCampos() {
        String precioNormal = tfPrecioNormal.getText();
        String precioEspecial = tfPrecioEspecial.getText();
        String precioNormalMoto = tfPrecioNormalMoto.getText();
        String precioEspecialMoto = tfPrecioEspecialMoto.getText();
        String tarjetaDamage = tfTarjetaDamage.getText();
        String tarjetaExtraviada = tfTarjetaExtraviada.getText();

        if (precioNormal.isEmpty()) {
            lbErrorPrecioNormal.setText("Campo Necesario");
            return false;
        } else {
            try {
                Double.parseDouble(precioNormal);
            } catch (NumberFormatException e) {
                lbErrorPrecioNormal.setText("Ingresar cantidad numerica");
                return false;
            }
        }

        if (precioEspecial.isEmpty()) {
            lbErrorPrecioEspecial.setText("Campo Necesario");
            return false;
        } else {
            try {
                Double.parseDouble(precioEspecial);
            } catch (NumberFormatException e) {
                lbErrorPrecioEspecial.setText("Ingresar cantidad numerica");
                return false;
            }
        }

        if (precioNormalMoto.isEmpty()) {
            lbErrorPrecioNormalMoto.setText("Campo Necesario");
            return false;
        } else {
            try {
                Double.parseDouble(precioNormalMoto);
            } catch (NumberFormatException e) {
                lbErrorPrecioNormalMoto.setText("Ingresar cantidad numerica");
                return false;
            }
        }

        if (precioEspecialMoto.isEmpty()) {
            lbErrorPrecioEspecialMoto.setText("Campo Necesario");
            return false;
        } else {
            try {
                Double.parseDouble(precioEspecialMoto);
            } catch (NumberFormatException e) {
                lbErrorPrecioEspecialMoto.setText("Ingresar cantidad numerica");
                return false;
            }
        }

        if (tarjetaDamage.isEmpty()) {
            lbErrorTarjetaDamage.setText("Campo Necesario");
            return false;
        } else {
            try {
                Double.parseDouble(tarjetaDamage);
            } catch (NumberFormatException e) {
                lbErrorTarjetaDamage.setText("Ingresar cantidad numerica");
                return false;
            }
        }

        if (tarjetaExtraviada.isEmpty()) {
            lbErrorTarjetaExtraviada.setText("Campo Necesario");
            return false;
        } else {
            try {
                Double.parseDouble(tarjetaExtraviada);
            } catch (NumberFormatException e) {
                lbErrorTarjetaExtraviada.setText("Ingresar cantidad numerica");
                return false;
            }
        }
        return true;
    }

    public void enviarConEnter() {
        tfContraseñaAdmin.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                lbErrorContraseñaAdmin.setText("");
                validarContraseñaAdmin();
            }

        });
    }

    @FXML
    private void clicBtnHistorial(ActionEvent event) {
        paneConfigurarPrecios.setDisable(true);
        paneConfigurarPrecios.setVisible(false);
        paneHistorialPrecios.setDisable(false);
        paneHistorialPrecios.setVisible(true);
        cargarInformacionTabla();
    }

    @FXML
    private void clicBtnBack(ActionEvent event) {
        paneHistorialPrecios.setDisable(true);
        paneHistorialPrecios.setVisible(false);
        paneConfigurarPrecios.setDisable(false);
        paneConfigurarPrecios.setVisible(true);

    }

     private void configurarTabla(){
         colIDPrecio.setCellValueFactory(new PropertyValueFactory("IDPrecio"));
         colHoraNormalCarro.setCellValueFactory(new PropertyValueFactory("precioHoraNormalCarro"));
         colHoraEspecialCarro.setCellValueFactory(new PropertyValueFactory("precioHoraEspecialCarro"));
         colHoraNormalMoto.setCellValueFactory(new PropertyValueFactory("precioHoraNormalMoto"));
         colHoraEspecialMoto.setCellValueFactory(new PropertyValueFactory("precioHoraEspecialMoto"));
         colTarjetaDañada.setCellValueFactory(new PropertyValueFactory("precioTarjetaDañada"));
         colTarjetaExtraviada.setCellValueFactory(new PropertyValueFactory("precioTarjetaExtraviada"));
    }
     
    private void cargarInformacionTabla(){
        configuracionesPrecios=FXCollections.observableArrayList();
        ConfiguracionPreciosRespuesta respuestaBD = ConfiguracionPreciosDAO.obtenerConfiguracionPrecios();
                switch(respuestaBD.getCodigoRespuesta()){
            case Constantes.ERROR_CONEXION:
                Utilidades.mostrarDialogoSimple("Sin conexión", 
                                                "Lo sentimos, por el momento no hay conexión para poder cargar la información.",
                                                Alert.AlertType.ERROR);
                break;
            case Constantes.ERROR_CONSULTA:
                Utilidades.mostrarDialogoSimple("Error al cargar los datos", 
                                                "Hubo un error al cargar la información, por favor intentelo más tarde.",
                                                Alert.AlertType.WARNING);
                break;
            case Constantes.OPERACION_EXITOSA:
                configuracionesPrecios.addAll(respuestaBD.getConfiguraciones()); //addAll hace la conversión de ArrayList y la mete al ObservableList
                tvHistorialPrecios.setItems(configuracionesPrecios);
                break;
        }
    }
   /*
    private void configurarGraficas() {
        configurarGraficaHoraNormalCarro();
        configurarGraficaHoraNormalMoto();
        configurarGraficaTarjetaExtraviada();
        configurarGraficaTarjetaDanada();
        configurarGraficaHoraEspecialMoto();
    }
    
    private void configuararGraficaHoraNormalCarro(){
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.setName("Precio Hora Normal Carro");
        
        for (ConfiguracionPrecios configuracion : configuracionesPrecios) {
        series.getData().add(new XYChart.Data<String, Double>(String.valueOf(configuracion.getIDPrecio()), configuracion.getPrecioHoraNormalCarro()));
    }
        grafHoraNormalCarro.getData().add(series);
    }
*/
}
