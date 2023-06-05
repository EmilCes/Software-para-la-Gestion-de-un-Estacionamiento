package sge.modelos.pojo;



public class Usuario {
    
    private int idUsuario;
    private int codigoRespuesta;
    private String nombreUsuario;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(int idUsuario, int codigoRespuesta, String nombreUsuario, String contraseña) {
        this.idUsuario = idUsuario;
        this.codigoRespuesta = codigoRespuesta;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }
    
}
