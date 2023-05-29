package sge.modelos.pojo;

public class Espacio {

    private int idCajon;
    private int numeroCajon;
    private int numeroPiso;
    private String tipoVehiculo;
    private String estadoEspacio;
    private int idTarjeta;
    private int respuesta;

    public Espacio() {
    }

    public Espacio(int idCajon, int numeroCajon, int numeroPiso, String tipoVehiculo, String estadoEspacio, int idTarjeta, int respuesta) {
        this.idCajon = idCajon;
        this.numeroCajon = numeroCajon;
        this.numeroPiso = numeroPiso;
        this.tipoVehiculo = tipoVehiculo;
        this.estadoEspacio = estadoEspacio;
        this.idTarjeta = idTarjeta;
        this.respuesta = respuesta;
    }

    public int getIdCajon() {
        return idCajon;
    }

    public int getNumeroCajon() {
        return numeroCajon;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getEstadoEspacio() {
        return estadoEspacio;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setIdCajon(int idCajon) {
        this.idCajon = idCajon;
    }

    public void setNumeroCajon(int numeroCajon) {
        this.numeroCajon = numeroCajon;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setEstadoEspacio(String estadoEspacio) {
        this.estadoEspacio = estadoEspacio;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

}
