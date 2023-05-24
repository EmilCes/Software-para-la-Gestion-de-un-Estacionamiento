package sge.utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Screen;
import javafx.stage.Stage;
import sge.SGE;



public class Utilidades {
    
    public static void mostrarDialogoSimple(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alertaSimple = new Alert(tipo);
        alertaSimple.setTitle(titulo);
        alertaSimple.setContentText(mensaje);
        alertaSimple.setHeaderText(null);
        alertaSimple.showAndWait();
    }
    
    public static Scene inicializarEscena(String ruta){
        Scene escena = null;
        try {
            Parent vista = FXMLLoader.load(SGE.class.getResource(ruta));
            escena = new Scene(vista);
        } catch (IOException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }
        return escena;
            
    }
    
    public static void centrarEscenario(Stage escenario) {
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        escenario.setX((limitesPantalla.getWidth() - escenario.getWidth()) / 2);
        escenario.setY((limitesPantalla.getHeight() - escenario.getHeight()) / 2);
    }
    
}