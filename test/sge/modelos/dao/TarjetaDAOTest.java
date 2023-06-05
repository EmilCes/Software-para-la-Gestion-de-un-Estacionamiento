package sge.modelos.dao;

import java.util.ArrayList;
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
    /**
     * Test of recuperarListaTarjetas method, of class TarjetaDAO.
     */
    @Test
    public void testRecuperarListaTarjetas() throws Exception {
        System.out.println("recuperarListaTarjetas");
        ArrayList<Tarjeta> expResult = null;
        ArrayList<Tarjeta> result = TarjetaDAO.recuperarListaTarjetas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarTarjeta method, of class TarjetaDAO.
     */
    @Test
    public void testBuscarTarjeta() {
        System.out.println("buscarTarjeta");
        int numeroTarjeta = 0;
        Tarjeta expResult = null;
        Tarjeta result = TarjetaDAO.buscarTarjeta(numeroTarjeta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarTarjeta method, of class TarjetaDAO.
     */
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
    
}
