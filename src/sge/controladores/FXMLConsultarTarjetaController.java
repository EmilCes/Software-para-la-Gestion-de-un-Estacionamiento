package sge.controladores;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sge.modelos.dao.ConfiguracionPreciosDAO;
import sge.modelos.pojo.ConfiguracionPrecios;
import sge.modelos.pojo.Tarjeta;

public class FXMLConsultarTarjetaController {
    private Tarjeta tarjeta;

    private Stage stage;
    private Scene scene;
    private Parent parent;
    
    @FXML
    private Button btnConsultarHistorial;

    @FXML
    private Button btnModificarTarjeta;

    @FXML
    private Label lCajon;

    @FXML
    private Label lEstado;

    @FXML
    private Label lNumeroTarjeta;

    @FXML
    private Label lPrecio;
    
    @FXML
    private AnchorPane apAdministrarTarjetas;
    @FXML
    private Pane pnAdministrarTarjetas;
    
    @FXML
    private Button btnRegresarMenú;

    @FXML
    void modificarTarjeta(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sge/vistas/FXMLModificarTarjeta.fxml"));
            parent = loader.load();
            FXMLModificarTarjetaController controller = (FXMLModificarTarjetaController)loader.getController();
            controller.cargarTarjeta(tarjeta);
            
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(parent);
            stage.setTitle("SGE");
            stage.setScene(scene);
            stage.show();
        }catch(IllegalStateException | IOException exception){
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setHeaderText("Error de carga");
            errorMessage.setContentText("No se pudo abrir la ventana, verifique que el archivo .fxml esté en su ubicación correcta");
            errorMessage.showAndWait();
        }
    }

    @FXML
    void mostrarHistorial(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sge/vistas/FXMLHistorialTarjeta.fxml"));
            parent = loader.load();
            FXMLHistorialTarjetaController controller = (FXMLHistorialTarjetaController)loader.getController();
            controller.cargarTarjeta(tarjeta);
            
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(parent);
            stage.setTitle("SGE");
            stage.setScene(scene);
            stage.show();
        }catch(IllegalStateException | IOException exception){
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setHeaderText("Error de carga");
            errorMessage.setContentText("No se pudo abrir la ventana, verifique que el archivo .fxml esté en su ubicación correcta");
            errorMessage.showAndWait();
        }
    }

    public void cargarTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
        
        lNumeroTarjeta.setText(String.valueOf(tarjeta.getIdTarjeta()));
        lEstado.setText(tarjeta.getEstadoTarjeta());
        lPrecio.setText(String.valueOf(recuperarPrecioTarjeta()));
        lCajon.setText(String.valueOf(tarjeta.getIdCajon()));
    }
    
    private double recuperarPrecioTarjeta() {
        ConfiguracionPrecios configuracionPrecios = ConfiguracionPreciosDAO.obtenerUltimaConfiguracionPrecios();
        double precioTarjeta;
        if (tarjeta.getIdTarjeta() <= 200) {
            precioTarjeta = configuracionPrecios.getPrecioHoraNormalCarro();
        } else {
            precioTarjeta = configuracionPrecios.getPrecioHoraNormalMoto();
        }
        return precioTarjeta;
    }

    @FXML
    private void regresarAMenú(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sge/vistas/FXMLMenuPrincipal.fxml"));
            parent = loader.load();
            FXMLMenuPrincipalController controller = (FXMLMenuPrincipalController)loader.getController();
            
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(parent);
            stage.setTitle("SGE");
            stage.setScene(scene);
            stage.show();
        }catch(IllegalStateException | IOException exception){
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setHeaderText("Error de carga");
            errorMessage.setContentText("No se pudo abrir la ventana, verifique que el archivo .fxml esté en su ubicación correcta");
            errorMessage.showAndWait();
        }
    }
}

