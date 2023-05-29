
package sge.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sge.modelos.ConexionBD;
import sge.modelos.pojo.ConfiguracionPrecios;
import sge.modelos.pojo.ConfiguracionPreciosRespuesta;
import sge.utils.Constantes;




public class ConfiguracionPreciosDAO {
    public static ConfiguracionPreciosRespuesta obtenerConfiguracionPrecios(){
        ConfiguracionPreciosRespuesta respuesta = new ConfiguracionPreciosRespuesta();
        respuesta.setCodigoRespuesta(Constantes.OPERACION_EXITOSA);
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String consulta = "SELECT IDPrecio, precioHoraNormalCarro, precioHoraEspecialCarro, precioHoraNormalMoto,"
                        + " precioHoraEspecialMoto, precioTarjetaDañada, precioTarjetaExtraviada FROM Precios"
                        + " ORDER BY IDPrecio DESC";

                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                ResultSet resultado = prepararSentencia.executeQuery();
                ArrayList<ConfiguracionPrecios> configuracionPreciosConsulta = new ArrayList();
                while(resultado.next()){
                    ConfiguracionPrecios configuracion = new ConfiguracionPrecios();
                    configuracion.setIDPrecio(resultado.getInt("IDPrecio"));
                    configuracion.setPrecioHoraNormalCarro(resultado.getDouble("precioHoraNormalCarro"));
                    configuracion.setPrecioHoraEspecialCarro(resultado.getDouble("precioHoraEspecialCarro"));
                    configuracion.setPrecioHoraNormalMoto(resultado.getDouble("precioHoraNormalMoto"));
                    configuracion.setPrecioHoraEspecialMoto(resultado.getDouble("precioHoraEspecialMoto"));
                    configuracion.setPrecioTarjetaDañada(resultado.getDouble("precioTarjetaDañada"));
                    configuracion.setPrecioTarjetaExtraviada(resultado.getDouble("precioTarjetaExtraviada"));
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
    
    public static ConfiguracionPrecios obtenerUltimaConfiguracionPrecios() {
    ConfiguracionPrecios configuracion = null;
    Connection conexionBD = ConexionBD.abrirConexionBD();
    if (conexionBD != null) {
        try {
            String consulta = "SELECT IDPrecio, precioHoraNormalCarro, precioHoraEspecialCarro, precioHoraNormalMoto,"
                    + " precioHoraEspecialMoto, precioTarjetaDañada, precioTarjetaExtraviada FROM Precios"
                    + " ORDER BY IDPrecio DESC LIMIT 1";
            PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
            ResultSet resultado = prepararSentencia.executeQuery();
            if (resultado.next()) {
                configuracion = new ConfiguracionPrecios();
                configuracion.setIDPrecio(resultado.getInt("IDPrecio"));
                configuracion.setPrecioHoraNormalCarro(resultado.getDouble("precioHoraNormalCarro"));
                configuracion.setPrecioHoraEspecialCarro(resultado.getDouble("precioHoraEspecialCarro"));
                configuracion.setPrecioHoraNormalMoto(resultado.getDouble("precioHoraNormalMoto"));
                configuracion.setPrecioHoraEspecialMoto(resultado.getDouble("precioHoraEspecialMoto"));
                configuracion.setPrecioTarjetaDañada(resultado.getDouble("precioTarjetaDañada"));
                configuracion.setPrecioTarjetaExtraviada(resultado.getDouble("precioTarjetaExtraviada"));
                configuracion.setRespuesta(Constantes.OPERACION_EXITOSA); // Asignar la respuesta aquí
            }
            conexionBD.close();
        } catch (SQLException e) {
            configuracion = new ConfiguracionPrecios();
            configuracion.setRespuesta(Constantes.ERROR_CONSULTA); // En caso de error, asignar la respuesta de error
        }
    } else {
        configuracion = new ConfiguracionPrecios();
        configuracion.setRespuesta(Constantes.ERROR_CONEXION); // En caso de error de conexión, asignar la respuesta de error
    }
    return configuracion;
}


    
 public static int guardarConfiguracionPrecios(ConfiguracionPrecios configuracionPrecios){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "INSERT INTO Precios (precioHoraNormalCarro, precioHoraEspecialCarro, precioHoraNormalMoto,"
                        + " precioHoraEspecialMoto, precioTarjetaDañada, precioTarjetaExtraviada) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(sentencia);
                prepararSentencia.setDouble(1, configuracionPrecios.getPrecioHoraNormalCarro());
                prepararSentencia.setDouble(2, configuracionPrecios.getPrecioHoraEspecialCarro());
                prepararSentencia.setDouble(3, configuracionPrecios.getPrecioHoraNormalMoto());
                prepararSentencia.setDouble(4, configuracionPrecios.getPrecioHoraEspecialMoto());
                prepararSentencia.setDouble(5, configuracionPrecios.getPrecioTarjetaDañada());
                prepararSentencia.setDouble(6, configuracionPrecios.getPrecioTarjetaExtraviada());
                int filasAfectadas = prepararSentencia.executeUpdate();
                respuesta = (filasAfectadas == 1) ? Constantes.OPERACION_EXITOSA : Constantes.ERROR_CONSULTA; //Operador ternario
                conexionBD.close();
            } catch(SQLException e){
                System.out.print(e.getMessage());
                respuesta = Constantes.ERROR_CONSULTA;
            }
        } else{
            respuesta = Constantes.ERROR_CONEXION;
        }
        
        return respuesta;
    }
}