package sge.modelos.pojo;

public class Espacio {

    private int idCajon;
    private int numeroCajon;
    private int numeroPiso;
    private String tipoVehiuclo;
    private String estadoEspacio;
    private int idTarjeta;

    public Espacio() {
    }

    public Espacio(int idCajon, int numeroCajon, int numeroPiso, String tipoVehiuclo, String estadoEspacio, int idTarjeta) {
        this.idCajon = idCajon;
        this.numeroCajon = numeroCajon;
        this.numeroPiso = numeroPiso;
        this.tipoVehiuclo = tipoVehiuclo;
        this.estadoEspacio = estadoEspacio;
        this.idTarjeta = idTarjeta;
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

    public String getTipoVehiuclo() {
        return tipoVehiuclo;
    }

    public String getEstadoEspacio() {
        return estadoEspacio;
    }

    public int getIdTarjeta() {
        return idTarjeta;
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

    public void setTipoVehiuclo(String tipoVehiuclo) {
        this.tipoVehiuclo = tipoVehiuclo;
    }

    public void setEstadoEspacio(String estadoEspacio) {
        this.estadoEspacio = estadoEspacio;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    @Override
    public String toString() {
        return "Espacio{" + "estadoEspacio=" + estadoEspacio + '}';
    }
    
    
    
}
