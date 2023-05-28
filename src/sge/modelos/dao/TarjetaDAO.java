package sge.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sge.modelos.ConexionBD;
import sge.modelos.pojo.Tarjeta;
import sge.utils.Constantes;


public class TarjetaDAO {

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

