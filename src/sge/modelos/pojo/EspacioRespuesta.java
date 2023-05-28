package sge.modelos.pojo;

import java.util.ArrayList;

public class EspacioRespuesta {
 
    private int codigoRespuesta;
    private ArrayList<Espacio> espacios;

    public EspacioRespuesta() {
    }

    public EspacioRespuesta(int codigoRespuesta, ArrayList<Espacio> espacios) {
        this.codigoRespuesta = codigoRespuesta;
        this.espacios = espacios;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public ArrayList<Espacio> getEspacios() {
        return espacios;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public void setEspacios(ArrayList<Espacio> espacios) {
        this.espacios = espacios;
    }
    
    
    
}
