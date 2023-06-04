package sge.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class FXMLAdministrarTarjetasController implements Initializable {

    @FXML
    private AnchorPane apAdministrarTarjetas;
    @FXML
    private Pane pnAdministrarTarjetas;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    private void cambiarPane(String path){
        apAdministrarTarjetas.getChildren().clear();
        try {
            FXMLLoader menuPrincipalLoader = new FXMLLoader(getClass().getResource(path));
            AnchorPane menuPrincipalPane = menuPrincipalLoader.load();
            apAdministrarTarjetas.getChildren().add(menuPrincipalPane);
        } catch (IOException ex) {
            System.err.println(ex.getStackTrace());
        }
    }

    @FXML
    private void clicBtnCambiarPantalla(ActionEvent event) {
        cambiarPane("/sge/vistas/FXMLConsultarTarjetas.fxml");
    }
    
}
