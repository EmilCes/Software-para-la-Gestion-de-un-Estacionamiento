package sge.modelos.pojo;



public class Tarjeta {
    
    private int idTarjeta;
    private String estadoTarjeta;
    private int idFechaHoraTarjeta;
    private int idCajon;
    private int respuesta;

    public Tarjeta() {
    }

    public Tarjeta(int idTarjeta, String estadoTarjeta, int idFechaHoraTarjeta, int idCajon, int respuesta) {
        this.idTarjeta = idTarjeta;
        this.estadoTarjeta = estadoTarjeta;
        this.idFechaHoraTarjeta = idFechaHoraTarjeta;
        this.idCajon = idCajon;
        this.respuesta = respuesta;
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

    public int getRespuesta() {
        return respuesta;
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

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public boolean equals(Object obj) {
    
        if (obj == this) {
            return true;
        }
 
      
        if (!(obj instanceof Tarjeta)) {
            return false;
        }
        
        Tarjeta tarjeta = (Tarjeta) obj;
        
        if(tarjeta.getEstadoTarjeta().equals(this.getEstadoTarjeta()) && tarjeta.getIdCajon() == this.getIdCajon()){
            return true;
        }
        return false;
      
    }
    
    
 
}
