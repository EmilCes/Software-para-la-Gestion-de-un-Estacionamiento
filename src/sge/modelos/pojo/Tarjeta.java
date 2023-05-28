package sge.modelos.pojo;



public class Tarjeta {
    
    private int idTarjeta;
    private String estadoTarjeta;
    private int idFechaHoraTarjeta;
    private int idCajon;

    public Tarjeta() {
    }

    public Tarjeta(int idTarjeta, String estadoTarjeta, int idFechaHoraTarjeta, int idCajon) {
        this.idTarjeta = idTarjeta;
        this.estadoTarjeta = estadoTarjeta;
        this.idFechaHoraTarjeta = idFechaHoraTarjeta;
        this.idCajon = idCajon;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public String getEstadoTarjeta() {
        return estadoTarjeta;
    }

    public int getIdFechaHoraTarjeta() {
        return idFechaHoraTarjeta;
    }

    public int getIdCajon() {
        return idCajon;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public void setEstadoTarjeta(String estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }

    public void setIdFechaHoraTarjeta(int idFechaHoraTarjeta) {
        this.idFechaHoraTarjeta = idFechaHoraTarjeta;
    }

    public void setIdCajon(int idCajon) {
        this.idCajon = idCajon;
    }
    
    
    
}
