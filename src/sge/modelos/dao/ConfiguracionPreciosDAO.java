
package sge.modelos.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                String consulta = "SELECT IDPrecio, precioHoraNormalCarro, precioHoraEspecialCarro, precioHoraNormalMoto,"
                        + " precioHoraEspecialMoto, precioTarjetaDañada, precioTarjetaExtraviada cantidad FROM Precios";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                ResultSet resultado = prepararSentencia.executeQuery();
                ArrayList<ConfiguracionPrecios> configuracionPreciosConsulta = new ArrayList();
                while(resultado.next()){
                    ConfiguracionPrecios configuracion = new ConfiguracionPrecios();
                    configuracion.setIDPrecio(resultado.getInt("IDPrecio"));
                    configuracion.setPrecioHoraNormalCarro("precioHoraNormalCarro");
                    configuracion.setPrecioHoraEspecialCarro("precioHoraEspecialCarro");
                    configuracion.setPrecioHoraNormalMoto("precioHoraNormalMoto");
                    configuracion.setPrecioHoraEspecialMoto("precioHoraEspeialMoto");
                    configuracion.setPrecioTarjetaDañada("precioTarjetaDañada");
                    configuracion.setPrecioTarjetaExtraviada("precioTarjetaExtraviada");
                    configuracionPreciosConsulta.add(configuracion);
                }
                respuesta.setConfiguraciones(configuracionPreciosConsulta);
                conexionBD.close();
            } catch(SQLException e){
                respuesta.setCodigoRespuesta(Constantes.ERROR_CONSULTA);
            }
        }else{
            respuesta.setCodigoRespuesta(Constantes.ERROR_CONEXION);
        }
        return respuesta;
    }

    
        public static int guardarConfiguracionPrecios(ConfiguracionPrecios configuracionPrecios){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "INSERT INTO Precios (precioHoraNormalCarro, precioHoraEspeciaalCarro, precioHoraNormalMoto,"
                        + " precioHoraEspecialMoto, precioTarjetaDañada, precioTarjetaExtraviada) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(sentencia);
                prepararSentencia.setDouble(1, configuracionPrecios.getPrecioHoraNormalCarro());
                prepararSentencia.setDouble(2, configuracionPrecios.getPrecioHoraEspecialCarro());
                prepararSentencia.setDouble(3, configuracionPrecios.getPrecioHoraNormalMoto());
                prepararSentencia.setDouble(4, configuracionPrecios.getPrecioHoraEspecialMoto());
                prepararSentencia.setDouble(5, configuracionPrecios.getPrecioTarjetaDañada());
                prepararSentencia.setDouble(6, configuracionPrecios.getPrecioTarjetaExtraviada());
                respuesta = (filasAfectadas == 1) ? Constantes.OPERACION_EXITOSA : Constantes.ERROR_CONSULTA; //Operador ternario
                conexionBD.close();
            } catch(SQLException e){
                respuesta = Constantes.ERROR_CONSULTA;
            }
        } else{
            respuesta = Constantes.ERROR_CONEXION;
        }
        
        return respuesta;
    }
}
*/