package sge.modelos.pojo;



public class FechaHoraTarjeta {
    
    private String fechaHoraEntrada;
    private String fechaHoraSalida;
    private int IDTarjeta;
    private int IDFechaHoraTarjeta;
    private int respuesta;

    public FechaHoraTarjeta() {
    }

    public FechaHoraTarjeta(String fechaHoraEntrada, String fechaHoraSalida, int IDTarjeta, int IDFechaHoraTarjeta, int respuesta) {
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.IDTarjeta = IDTarjeta;
        this.IDFechaHoraTarjeta = IDFechaHoraTarjeta;
        this.respuesta = respuesta;
    }

    public String getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public String getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public int getIDTarjeta() {
        return IDTarjeta;
    }

    public int getIDFechaHoraTarjeta() {
        return IDFechaHoraTarjeta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setFechaHoraEntrada(String fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setIDTarjeta(int IDTarjeta) {
        this.IDTarjeta = IDTarjeta;
    }

    public void setIDFechaHoraTarjeta(int IDFechaHoraTarjeta) {
        this.IDFechaHoraTarjeta = IDFechaHoraTarjeta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
    
}
