package sge.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sge.modelos.ConexionBD;
import sge.modelos.pojo.Tarjeta;
import sge.utils.Constantes;


public class TarjetaDAO {
    
    public static Tarjeta buscarTarjeta(int numeroTarjeta){
        Tarjeta respuesta = new Tarjeta();
        respuesta.setRespuesta(Constantes.OPERACION_EXITOSA);
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try {
                String sentencia = "SELECT IDTarjeta, estado, IDFechaHoraTarjeta, IDCajon FROM Tarjetas WHERE IDTarjeta = ?";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(sentencia);
                prepararSentencia.setInt(1, numeroTarjeta);
                ResultSet resultado = prepararSentencia.executeQuery();
                resultado.next();
                respuesta.setIdTarjeta(resultado.getInt("IDTarjeta"));
                respuesta.setEstadoTarjeta(resultado.getString("estado"));
                respuesta.setIdFechaHoraTarjeta(resultado.getInt("IDFechaHoraTarjeta"));
                respuesta.setIdCajon(resultado.getInt("IDCajon"));
                conexionBD.close();
            } catch (SQLException e) {
                respuesta.setRespuesta(Constantes.ERROR_CONSULTA);
            }
        } else{
            respuesta.setRespuesta(Constantes.ERROR_CONEXION);
        }
        return respuesta;
    }

    public static int actualizarTarjeta(Tarjeta tarjeta){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "UPDATE Tarjetas SET estado = ?, IDFechaHoraTarjeta = ? WHERE IDTarjeta = ?";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(sentencia);
                prepararSentencia.setString(1, tarjeta.getEstadoTarjeta());
                prepararSentencia.setInt(2, tarjeta.getIdFechaHoraTarjeta());
                prepararSentencia.setInt(3, tarjeta.getIdTarjeta());
                int filasAfectadas = prepararSentencia.executeUpdate();
                respuesta = (filasAfectadas == 1) ? Constantes.OPERACION_EXITOSA : Constantes.ERROR_CONSULTA;
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
