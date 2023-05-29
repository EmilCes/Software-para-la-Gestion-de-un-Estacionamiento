package sge.modelos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sge.modelos.ConexionBD;
import sge.modelos.pojo.Usuario;
import sge.utils.Constantes;

public class InicioSesionDAO {

    public static Usuario verificarUsuarioSesion(String usuario, String password) {

        Usuario usuarioVerificado = new Usuario();
        Connection conexion = ConexionBD.abrirConexionBD();
        if (conexion != null) {
            try {
                String consulta = "SELECT IDUsuario, nombreUsuario, contraseña FROM Usuarios WHERE nombreUsuario = ? AND contraseña = ?";
                PreparedStatement prepararSentencia = conexion.prepareStatement(consulta); //Prevenir SQL Inyections
                prepararSentencia.setString(1, usuario);
                prepararSentencia.setString(2, password);
                ResultSet resultado = prepararSentencia.executeQuery();
                usuarioVerificado.setCodigoRespuesta(Constantes.OPERACION_EXITOSA);
                if (resultado.next()) {
                    usuarioVerificado.setIdUsuario(resultado.getInt("IDUsuario"));
                    usuarioVerificado.setNombreUsuario(resultado.getString("nombreUsuario"));
                    usuarioVerificado.setContraseña(resultado.getString("contraseña"));
                }
                conexion.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                usuarioVerificado.setCodigoRespuesta(Constantes.ERROR_CONSULTA);
            }
        } else {
            usuarioVerificado.setCodigoRespuesta(Constantes.ERROR_CONEXION);
        }
        return usuarioVerificado;

    }

    public static Usuario verificarAdminSesion(String password) {
        Usuario usuarioVerificado = new Usuario();
        Connection conexion = ConexionBD.abrirConexionBD();
        if (conexion != null) {
            try {
                String consulta = "SELECT IDUsuario, nombreUsuario, contraseña FROM Usuarios WHERE nombreUsuario = 'admin' AND contraseña = ?";
                PreparedStatement prepararSentencia = conexion.prepareStatement(consulta); //Prevenir SQL Inyections
                prepararSentencia.setString(1, password);
                ResultSet resultado = prepararSentencia.executeQuery();
                usuarioVerificado.setCodigoRespuesta(Constantes.OPERACION_EXITOSA);
                if (resultado.next()) {
                    usuarioVerificado.setIdUsuario(resultado.getInt("IDUsuario"));
                    usuarioVerificado.setNombreUsuario(resultado.getString("nombreUsuario"));
                    usuarioVerificado.setContraseña(resultado.getString("contraseña"));
                }
                conexion.close();
            }catch (SQLException ex) {
                System.out.println(ex.getMessage());
                usuarioVerificado.setCodigoRespuesta(Constantes.ERROR_CONSULTA);
            }
        } else {
            usuarioVerificado.setCodigoRespuesta(Constantes.ERROR_CONEXION);
        }
        return usuarioVerificado;
    }

}
