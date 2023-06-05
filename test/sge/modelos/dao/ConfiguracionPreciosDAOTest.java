/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sge.modelos.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import sge.modelos.pojo.ConfiguracionPrecios;
import sge.utils.Constantes;

public class ConfiguracionPreciosDAOTest {
    
    public ConfiguracionPreciosDAOTest() {
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
    public void tearDown(){
    }



    @Test
    public void testObtenerUltimaConfiguracionPrecios() {
        System.out.println("obtenerUltimaConfiguracionPrecios");
        ConfiguracionPrecios expResult = new ConfiguracionPrecios();
        expResult.setRespuesta(Constantes.OPERACION_EXITOSA);
        ConfiguracionPrecios result = ConfiguracionPreciosDAO.obtenerUltimaConfiguracionPrecios();
        assertEquals(expResult, result);

    }
}
