package sge.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sge.modelos.ConexionBD;
import sge.modelos.pojo.FechaHoraTarjeta;
import sge.utils.Constantes;



public class FechaHoraTarjetaDAO {
    
    public static int obtenerIdFechaHoraTarjeta(){
        int idFechaHoraTarjeta = -1;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "SELECT IDFechaHoraTarjeta FROM FechaHorasTarjetas ORDER BY IDFechaHoraTarjeta DESC LIMIT 1";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(sentencia);
                ResultSet resultado = prepararSentencia.executeQuery();
                resultado.next();
                idFechaHoraTarjeta = resultado.getInt("IDFechaHoraTarjeta");
                
                conexionBD.close();
            } catch(SQLException e){
                System.out.println(e.getMessage());
                //System.out.println("Error en el sistema");
            }
        }
        return idFechaHoraTarjeta;
    }
    
    public static FechaHoraTarjeta buscarFechaHoraTarjeta(int idFechaHoraTarjeta){
        FechaHoraTarjeta respuesta = new FechaHoraTarjeta();
        respuesta.setRespuesta(Constantes.OPERACION_EXITOSA);
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try {
                String sentencia = "SELECT IDFechaHoraTarjeta, fechaHoraEntrada FROM FechaHorasTarjetas WHERE IDFechaHoraTarjeta = ?";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(sentencia);
                prepararSentencia.setInt(1, idFechaHoraTarjeta);
                ResultSet resultado = prepararSentencia.executeQuery();
                resultado.next();
                respuesta.setIDFechaHoraTarjeta(resultado.getInt("IDFechaHoraTarjeta"));
                respuesta.setFechaHoraEntrada(resultado.getString("fechaHoraEntrada"));
                conexionBD.close();
            } catch (SQLException e) {
                respuesta.setRespuesta(Constantes.ERROR_CONSULTA);
            }
        } else{
            respuesta.setRespuesta(Constantes.ERROR_CONEXION);
        }
        return respuesta;
    }
    
}
