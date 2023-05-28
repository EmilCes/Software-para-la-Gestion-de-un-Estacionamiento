package sge.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sge.modelos.ConexionBD;
import sge.modelos.pojo.Espacio;
import sge.modelos.pojo.EspacioRespuesta;
import sge.modelos.pojo.FechaHoraTarjeta;
import sge.utils.Constantes;



public class EspacioDAO {
    
    public static EspacioRespuesta obtenerDisponibilidadEspacios(){
        EspacioRespuesta respuesta = new EspacioRespuesta();
        respuesta.setCodigoRespuesta(Constantes.OPERACION_EXITOSA);
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String consulta = "SELECT Cajones.IDCajon AS IDCajon, numeroCajon, piso, tipoVehiculo, Tarjetas.IDTarjeta, Tarjetas.estado AS estado "
                                + "FROM Cajones INNER JOIN Tarjetas ON Cajones.IDCajon = Tarjetas.IDTarjeta";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(consulta);
                ResultSet resultado = prepararSentencia.executeQuery();
                ArrayList<Espacio> espaciosConsulta = new ArrayList();
                while(resultado.next()){
                    Espacio espacio = new Espacio();
                    espacio.setIdCajon(resultado.getInt("IDCajon"));
                    espacio.setNumeroCajon(resultado.getInt("numeroCajon"));
                    espacio.setNumeroPiso(resultado.getInt("piso"));
                    espacio.setTipoVehiuclo(resultado.getString("tipoVehiculo"));
                    espacio.setIdTarjeta(resultado.getInt("IDTarjeta"));
                    espacio.setEstadoEspacio(resultado.getString("estado"));
                    espaciosConsulta.add(espacio);
                }
                respuesta.setEspacios(espaciosConsulta);
                conexionBD.close();
            } catch(SQLException e){
                respuesta.setCodigoRespuesta(Constantes.ERROR_CONSULTA);
            }
        } else{
            respuesta.setCodigoRespuesta(Constantes.ERROR_CONEXION);
        }
        return respuesta;
    }
    
    public static int guardarAsignacion(FechaHoraTarjeta fechaHoraTarjeta){
        
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try{
                String sentencia = "INSERT INTO FechaHorasTarjetas (fechaHoraEntrada, IDTarjeta) " +
                                   "VALUES (?, ?)";
                PreparedStatement prepararSentencia = conexionBD.prepareStatement(sentencia);
                prepararSentencia.setString(1, fechaHoraTarjeta.getFechaHoraEntrada());
                prepararSentencia.setInt(2, fechaHoraTarjeta.getIDTarjeta());
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

 