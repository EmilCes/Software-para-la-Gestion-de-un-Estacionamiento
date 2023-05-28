package sge.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sge.modelos.ConexionBD;



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
    
}
