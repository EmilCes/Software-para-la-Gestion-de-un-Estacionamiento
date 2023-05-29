
package sge.modelos.pojo;

public class ConfiguracionPrecios {
    
  private int IDPrecio;  
  private double precioHoraNormalCarro;
  private double precioHoraEspecialCarro;
  private double precioHoraNormalMoto;
  private double precioHoraEspecialMoto;
  private double precioTarjetaDañada;
  private double precioTarjetaExtraviada;
  int respuesta;

    public ConfiguracionPrecios() {
    }

    public ConfiguracionPrecios(int IDPrecio, double precioHoraNormalCarro, double precioHoraEspecialCarro, double precioHoraNormalMoto, double precioHoraEspecialMoto, double precioTarjetaDañada, double precioTarjetaExtraviada) {
        this.IDPrecio = IDPrecio;
        this.precioHoraNormalCarro = precioHoraNormalCarro;
        this.precioHoraEspecialCarro = precioHoraEspecialCarro;
        this.precioHoraNormalMoto = precioHoraNormalMoto;
        this.precioHoraEspecialMoto = precioHoraEspecialMoto;
        this.precioTarjetaDañada = precioTarjetaDañada;
        this.precioTarjetaExtraviada = precioTarjetaExtraviada;
    }


    
    public ConfiguracionPrecios(double precioHoraNormalCarro, double precioHoraEspecialCarro, double precioHoraNormalMoto, double precioHoraEspecialMoto, double precioTarjetaDañada, double precioTarjetaExtraviada) {
        this.precioHoraNormalCarro = precioHoraNormalCarro;
        this.precioHoraEspecialCarro = precioHoraEspecialCarro;
        this.precioHoraNormalMoto = precioHoraNormalMoto;
        this.precioHoraEspecialMoto = precioHoraEspecialMoto;
        this.precioTarjetaDañada = precioTarjetaDañada;
        this.precioTarjetaExtraviada = precioTarjetaExtraviada;
    }

    public int getIDPrecio() {
        return IDPrecio;
    }
    
    public double getPrecioHoraNormalCarro() {
        return precioHoraNormalCarro;
    }

    public double getPrecioHoraEspecialCarro() {
        return precioHoraEspecialCarro;
    }

    public double getPrecioHoraNormalMoto() {
        return precioHoraNormalMoto;
    }

    public double getPrecioHoraEspecialMoto() {
        return precioHoraEspecialMoto;
    }

    public double getPrecioTarjetaDañada() {
        return precioTarjetaDañada;
    }

    public double getPrecioTarjetaExtraviada() {
        return precioTarjetaExtraviada;
    }

    public int getRespuesta() {
        return respuesta;
    }
    
    

    public void setIDPrecio(int IDPrecio) {
        this.IDPrecio = IDPrecio;
    }
    
    public void setPrecioHoraNormalCarro(double precioHoraNormalCarro) {
        this.precioHoraNormalCarro = precioHoraNormalCarro;
    }

    public void setPrecioHoraEspecialCarro(double precioHoraEspecialCarro) {
        this.precioHoraEspecialCarro = precioHoraEspecialCarro;
    }

    public void setPrecioHoraNormalMoto(double precioHoraNormalMoto) {
        this.precioHoraNormalMoto = precioHoraNormalMoto;
    }

    public void setPrecioHoraEspecialMoto(double precioHoraEspecialMoto) {
        this.precioHoraEspecialMoto = precioHoraEspecialMoto;
    }

    public void setPrecioTarjetaDañada(double precioTarjetaDañada) {
        this.precioTarjetaDañada = precioTarjetaDañada;
    }

    public void setPrecioTarjetaExtraviada(double precioTarjetaExtraviada) {
        this.precioTarjetaExtraviada = precioTarjetaExtraviada;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
  
    
  
 
    
}
