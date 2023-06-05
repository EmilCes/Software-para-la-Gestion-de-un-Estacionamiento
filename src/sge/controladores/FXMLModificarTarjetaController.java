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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sge.modelos.dao.TarjetaDAO;
import sge.modelos.pojo.Tarjeta;

public class FXMLModificarTarjetaController {
    private Tarjeta tarjeta;

    private Stage stage;
    private Scene scene;
    private Parent parent;
    
    @FXML
    private Button btnCancelarModificacion;

    @FXML
    private Button btnGuardarEstado;

    @FXML
    private Label lCajon;

    @FXML
    private Label lNumeroTarjeta;

    @FXML
    private Label lPrecio;
    
    @FXML
    private TextField tfEstado;
    @FXML
    private AnchorPane apModificarTarjeta;
    @FXML
    private Pane pnModificarTarjeta;
    
    @FXML
    void guardarEstado(ActionEvent event) {
        tarjeta.setEstadoTarjeta(tfEstado.getText());
        int resultado;
        resultado = TarjetaDAO.actualizarTarjeta(tarjeta);
        
        switch (resultado) {
            case 200:
                Alert successMessage = new Alert(Alert.AlertType.CONFIRMATION);
                successMessage.setHeaderText("Operación exitosa");
                successMessage.setContentText("Se ha guardado el nuevo estado correctamente.");
                successMessage.showAndWait();
            case 500:
                Alert errorMessage = new Alert(Alert.AlertType.CONFIRMATION);
                errorMessage.setHeaderText("Ocurrió un error");
                errorMessage.setContentText("No se pudo guardar la información.");
                errorMessage.showAndWait();
            case 501:
                Alert connectionErrorMessage = new Alert(Alert.AlertType.CONFIRMATION);
                connectionErrorMessage.setHeaderText("Ocurrió un error");
                connectionErrorMessage.setContentText("Error de Conexión.");
                connectionErrorMessage.showAndWait();
        }
    }

    @FXML
    private void regresarAConsultaTarjeta(ActionEvent event) {
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
    }
}
