
package sge.modelos.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import sge.modelos.pojo.ConfiguracionPrecios;
import sge.modelos.pojo.ConfiguracionPreciosRespuesta;
import sge.utils.Constantes;

/*
public class ConfiguracionPreciosDAO {
    public static ConfiguracionPreciosRespuesta obtenerConfiguracionPrecios(){
        ConfiguracionPreciosRespuesta respuesta = new ConfiguracionPreciosRespuesta();
        respuesta.setCodigoRespuesta(Constantes.OPERACION_EXITOSA);
        Connection conexionBD = ConexionBD.abrirConecionBD();
        if(concexioBD != null){
            try{
                String consulta = "SELECT IDPrecio, descripción, cantidad FROM Precios";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                ResultSet resultado = prepararSentencia.executeQuery();
                ArrayList<ConfiguracionPrecios> configuracionPreciosConsulta = new ArrayList();
                while(resultado.next()){
                    ConfiguracionPrecios configuracion = new ConfiguracionPrecios();
                    configuracion.setIDPrecio(resultado.getInt("IDPrecio"));
                    configuracion.setDescripcion(resultado.getString("descripción"));
                    configuracion.setCantidad(resultado.getDouble("cantidad"));
                    configuracionPreciosConsulta.add(configuracion);
                }
                
            }
        }
    }

}
*/