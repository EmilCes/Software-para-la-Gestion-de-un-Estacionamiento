
package sge.modelos.pojo;

public class ConfiguracionPrecios {
    
    private double precioNormalCarro;
    private double precioEspecialCarro;
    private double precioNormalMoto;
    private double precioEspecialMoto;
    private double tarjetaDamage;
    private double tarjetaExtraviada;

    public ConfiguracionPrecios() {
    }

    public ConfiguracionPrecios(double precioNormalCarro, double precioEspecialCarro, double precioNormalMoto, double precioEspecialMoto, double tarjetaDamage, double tarjetaExtraviada) {
        this.precioNormalCarro = precioNormalCarro;
        this.precioEspecialCarro = precioEspecialCarro;
        this.precioNormalMoto = precioNormalMoto;
        this.precioEspecialMoto = precioEspecialMoto;
        this.tarjetaDamage = tarjetaDamage;
        this.tarjetaExtraviada = tarjetaExtraviada;
    }

    public double getPrecioNormalCarro() {
        return precioNormalCarro;
    }

    public double getPrecioEspecialCarro() {
        return precioEspecialCarro;
    }

    public double getPrecioNormalMoto() {
        return precioNormalMoto;
    }

    public double getPrecioEspecialMoto() {
        return precioEspecialMoto;
    }

    public double getTarjetaDamage() {
        return tarjetaDamage;
    }

    public double getTarjetaExtraviada() {
        return tarjetaExtraviada;
    }

    
    public void setPrecioNormalCarro(double precioNormalCarro) {
        this.precioNormalCarro = precioNormalCarro;
    }

    public void setPrecioEspecialCarro(double precioEspecialCarro) {
        this.precioEspecialCarro = precioEspecialCarro;
    }

    public void setPrecioNormalMoto(double precioNormalMoto) {
        this.precioNormalMoto = precioNormalMoto;
    }

    public void setPrecioEspecialMoto(double precioEspecialMoto) {
        this.precioEspecialMoto = precioEspecialMoto;
    }

    public void setTarjetaDamage(double tarjetaDamage) {
        this.tarjetaDamage = tarjetaDamage;
    }

    public void setTarjetaExtraviada(double tarjetaExtraviada) {
        this.tarjetaExtraviada = tarjetaExtraviada;
    }

    
    
}
