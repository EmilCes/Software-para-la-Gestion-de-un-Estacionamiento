
package sge.modelos.pojo;

public class ConfiguracionPrecios {
    
    private int IDPrecio;
    private String descripcion;
    private double cantidad;

    public ConfiguracionPrecios() {
    }

    public ConfiguracionPrecios(int IDPrecio, String descripcion, double cantidad) {
        this.IDPrecio = IDPrecio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public int getIDPrecio() {
        return IDPrecio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setIDPrecio(int IDPrecio) {
        this.IDPrecio = IDPrecio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
}
