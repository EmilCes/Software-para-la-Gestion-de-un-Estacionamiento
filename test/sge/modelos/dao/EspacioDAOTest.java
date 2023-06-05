package sge.modelos.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sge.modelos.pojo.Espacio;
import sge.modelos.pojo.EspacioRespuesta;
import sge.modelos.pojo.FechaHoraTarjeta;

public class EspacioDAOTest {
    
    public EspacioDAOTest() {
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
    public void testObtenerDisponibilidadEspacios() {
        EspacioRespuesta expResult = new EspacioRespuesta(200, null);
        EspacioRespuesta result = EspacioDAO.obtenerDisponibilidadEspacios();
        assertEquals("Obtener disponibilidad de espacios éxitoso", expResult, result);
    }   
}
