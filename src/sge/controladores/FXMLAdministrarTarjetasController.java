package sge.controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sge.modelos.dao.TarjetaDAO;
import sge.modelos.pojo.Tarjeta;

public class FXMLAdministrarTarjetasController {
    private boolean estaBuscando = false;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    
    @FXML
    public static AnchorPane apAdministrarTarjetas;
    
    @FXML
    private TextField tfBuscarTarjeta;
    
    @FXML
    private Button btnBuscarTarjeta;

    @FXML
    private Button btnRegistrarTarjeta;

    @FXML
    private VBox vBoxListaTarjetas;
    
    @FXML
    private Label lAdvertencia;

    @FXML
    private void initialize() {
        lAdvertencia.setVisible(false);
        
        try {
            ArrayList<Tarjeta> listaTarjetas = TarjetaDAO.recuperarListaTarjetas();
            
            for (Tarjeta tarjeta : listaTarjetas) {
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sge/vistas/FXMLElementoListaTarjetas.fxml"));
                try {
                    Pane PaneTarjeta = loader.load();
                    FXMLElementoListaTarjetasController controller = (FXMLElementoListaTarjetasController)loader.getController();
                    controller.cargarTarjeta(tarjeta);
                    
                    vBoxListaTarjetas.getChildren().add(PaneTarjeta);
                } catch (IOException | IllegalStateException excepcion) {
                    Alert errorMessage = new Alert(Alert.AlertType.ERROR);
                    errorMessage.setHeaderText("Error de carga");
                    errorMessage.setContentText("No se pudo abrir la ventana, verifique que el archivo .fxml esté en su ubicación correcta");
                    errorMessage.showAndWait();
                }
            }
        } catch (SQLException excepcion) {
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setHeaderText("Error al recuperar datos");
            errorMessage.setContentText(excepcion.getMessage());
            errorMessage.showAndWait();
        }
    }
    
    @FXML
    void buscarTarjetaPorID(ActionEvent event) {
        int idTarjeta = (!tfBuscarTarjeta.getText().equals("")) ? Integer.parseInt(tfBuscarTarjeta.getText()): 0 ;
        Tarjeta tarjeta;
        
        if (idTarjeta > 0) {
            tarjeta = TarjetaDAO.buscarTarjeta(idTarjeta);
            vBoxListaTarjetas.getChildren().clear();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sge/vistas/FXMLElementoListaTarjetas.fxml"));
            try {
                Pane PaneTarjeta = loader.load();
                FXMLElementoListaTarjetasController controller = (FXMLElementoListaTarjetasController)loader.getController();
                if (tarjeta.getIdTarjeta() != 0) {
                    controller.cargarTarjeta(tarjeta);
                    vBoxListaTarjetas.getChildren().add(PaneTarjeta);
                } else {
                    lAdvertencia.setText("No se encontraron coincidencias.");
                    lAdvertencia.setVisible(true);
                }
            } catch (IOException | IllegalStateException excepcion) {
                Alert errorMessage = new Alert(Alert.AlertType.ERROR);
                errorMessage.setHeaderText("Error de carga");
                errorMessage.setContentText("No se pudo abrir la ventana, verifique que el archivo .fxml esté en su ubicación correcta");
                errorMessage.showAndWait();
            }           
            estaBuscando = true;
        } else if (estaBuscando) {    
            vBoxListaTarjetas.getChildren().clear();
            estaBuscando = false;
            initialize();
        }
        
    }

    @FXML
    void registrarTarjeta(ActionEvent event) { //TODO
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sge/vistas/FXMLRegistrarTarjeta.fxml"));
            parent = loader.load();
            FXMLRegistrarTarjetaController controller = (FXMLRegistrarTarjetaController)loader.getController();
            
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(parent);
            stage.setTitle("SPGER");
            stage.setScene(scene);
            stage.show();
        }catch(IllegalStateException | IOException exception){
            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
            errorMessage.setHeaderText("Error de carga");
            errorMessage.setContentText("No se pudo abrir la ventana, verifique que el archivo .fxml esté en su ubicación correcta");
            errorMessage.showAndWait();
        }
    }

//    public void cambiarPane(String path){
//        try{
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/uv/fei/gui/fxml/chronogram/ActivityInfo.fxml"));
//            parent = loader.load();
//            FXMLRegistrarTarjetaController controller = (FXMLRegistrarTarjetaController)loader.getController();
//            
//            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//            scene = new Scene(parent);
//            stage.setTitle("SPGER");
//            stage.setScene(scene);
//            stage.show();
//        }catch(IllegalStateException | IOException exception){
//            Alert errorMessage = new Alert(Alert.AlertType.ERROR);
//            errorMessage.setHeaderText("Error de carga");
//            errorMessage.setContentText("No se pudo abrir la ventana, verifique que el archivo .fxml esté en su ubicación correcta");
//            errorMessage.showAndWait();
//        }
//    }
}
