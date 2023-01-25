/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

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
public class VistaAnularVentaTest {
    
    public VistaAnularVentaTest() {
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
     * Test of buscarVenta method, of class VistaAnularVenta.
     */
    @Test
    public void testBuscarVenta() {
        System.out.println("buscarVenta");
        VistaAnularVenta instance = new VistaAnularVenta();
        instance.buscarVenta();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarVentaEspecifica method, of class VistaAnularVenta.
     */
    @Test
    public void testBuscarVentaEspecifica() {
        System.out.println("buscarVentaEspecifica");
        String id_venta = "";
        VistaAnularVenta instance = new VistaAnularVenta();
        instance.buscarVentaEspecifica(id_venta);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarVenta method, of class VistaAnularVenta.
     */
    @Test
    public void testEliminarVenta() {
        System.out.println("eliminarVenta");
        VistaAnularVenta instance = new VistaAnularVenta();
        instance.eliminarVenta();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarVenta method, of class VistaAnularVenta.
     */
    @Test
    public void testMostrarVenta() {
        System.out.println("mostrarVenta");
        VistaAnularVenta instance = new VistaAnularVenta();
        instance.mostrarVenta();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
