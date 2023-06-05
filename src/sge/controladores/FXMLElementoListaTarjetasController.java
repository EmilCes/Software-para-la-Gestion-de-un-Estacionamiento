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
import javafx.stage.Stage;
import sge.modelos.pojo.Tarjeta;

public class FXMLElementoListaTarjetasController {
    private Tarjeta tarjeta;
    
    private Stage stage;
    private Scene scene;
    private Parent parent;

    @FXML
    private Label lbIDTarjeta;

    @FXML
    private Label lbEstadoTarjeta;

    @FXML
    private Button btnVerDetalles;

    @FXML
    void mostrarDetallesTarjeta(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sge/vistas/FXMLConsultarTarjeta.fxml"));
            parent = loader.load();
            FXMLConsultarTarjetaController controller = (FXMLConsultarTarjetaController)loader.getController();
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
        lbIDTarjeta.setText(String.valueOf(tarjeta.getIdTarjeta()));
        lbEstadoTarjeta.setText(tarjeta.getEstadoTarjeta());
    }   
}
