
package sge.modelos.pojo;

import java.util.ArrayList;


public class ConfiguracionPreciosRespuesta {
    
    private int codigoRespuesta;
    private ArrayList<ConfiguracionPrecios> configuraciones;

    public ConfiguracionPreciosRespuesta() {
    }

    public ConfiguracionPreciosRespuesta(int codigoRespuesta, ArrayList<ConfiguracionPrecios> configuraciones) {
        this.codigoRespuesta = codigoRespuesta;
        this.configuraciones = configuraciones;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public ArrayList<ConfiguracionPrecios> getConfiguraciones() {
        return configuraciones;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public void setConfiguraciones(ArrayList<ConfiguracionPrecios> configuraciones) {
        this.configuraciones = configuraciones;
    }
    
    
}
