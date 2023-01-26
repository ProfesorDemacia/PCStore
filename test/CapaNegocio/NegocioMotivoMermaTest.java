/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.MotivoMerma;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cesar
 */
public class NegocioMotivoMermaTest {
    
    public NegocioMotivoMermaTest() {
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
     * Test of configurarConexion method, of class NegocioMotivoMerma.
     */
    @Test
    public void testConfigurarConexion() {
        System.out.println("configurarConexion");
        NegocioMotivoMerma instance = new NegocioMotivoMerma();
        instance.configurarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarMotivoMerma method, of class NegocioMotivoMerma.
     */
    @Test
    public void testInsertarMotivoMerma() {
        System.out.println("insertarMotivoMerma");
        MotivoMerma motivomerma = new MotivoMerma();
        NegocioMotivoMerma instance = new NegocioMotivoMerma();
        instance.insertarMotivoMerma(motivomerma);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of consultaMerma method, of class NegocioMotivoMerma.
     */

    /**
     * Test of buscaMotivoMerma method, of class NegocioMotivoMerma.
     */
    @Test
    public void testBuscaMotivoMerma() {
        System.out.println("buscaMotivoMerma");
        int id_prod = 21;
        NegocioMotivoMerma instance = new NegocioMotivoMerma();
        MotivoMerma expResult = instance.buscaMotivoMerma(id_prod);
        MotivoMerma result = instance.buscaMotivoMerma(id_prod);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of existeProducto method, of class NegocioMotivoMerma.
     */
    @Test
    public void testExisteProducto() {
        System.out.println("existeProducto");
        int id_prod = 0;
        NegocioMotivoMerma instance = new NegocioMotivoMerma();
        boolean expResult = false;
        boolean result = instance.existeProducto(id_prod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getConec1 method, of class NegocioMotivoMerma.
     */
    @Test
    public void testGetConec1() {
        System.out.println("getConec1");
        NegocioMotivoMerma instance = new NegocioMotivoMerma();
        ConexionMySQL expResult = null;
        ConexionMySQL result = instance.getConec1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setConec1 method, of class NegocioMotivoMerma.
     */
    @Test
    public void testSetConec1() {
        System.out.println("setConec1");
        ConexionMySQL conec1 = null;
        NegocioMotivoMerma instance = new NegocioMotivoMerma();
        instance.setConec1(conec1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
