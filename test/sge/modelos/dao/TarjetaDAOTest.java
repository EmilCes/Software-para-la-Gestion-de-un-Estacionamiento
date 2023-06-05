package sge.modelos.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sge.modelos.pojo.Tarjeta;

public class TarjetaDAOTest {
    
    public TarjetaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testActualizarTarjeta() {
        System.out.println("actualizarTarjeta");
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setIdTarjeta(1);
        tarjeta.setEstadoTarjeta("Perdida");
        int expResult = 200;
        int result = TarjetaDAO.actualizarTarjeta(tarjeta);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testBuscarTarjeta() {
        int numeroTarjeta = 1;
        Tarjeta expResult = new Tarjeta(1, "Sin Tarjeta", 21,1, 200);
        Tarjeta result = TarjetaDAO.buscarTarjeta(numeroTarjeta);
        assertEquals("Busca tarjeta por ID exitoso",expResult, result);
    }
    
    @Test
    public void testBuscarTarjetaErrorConsulta() {
        int numeroTarjeta = -1;
        int expResult = 501;
        int result = TarjetaDAO.buscarTarjeta(numeroTarjeta).getRespuesta();
        assertEquals("Busca tarjeta por ID error consulta",expResult, result);
    }

}
