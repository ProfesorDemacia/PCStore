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
public class VistaCajeroTest {
    
    public VistaCajeroTest() {
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
     * Test of limpiarDatos method, of class VistaCajero.
     */
    @Test
    public void testLimpiarDatos() {
        System.out.println("limpiarDatos");
        VistaCajero instance = new VistaCajero();
        instance.limpiarDatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarTabla method, of class VistaCajero.
     */
    @Test
    public void testLimpiarTabla() {
        System.out.println("limpiarTabla");
        VistaCajero instance = new VistaCajero();
        instance.limpiarTabla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimirBoleta method, of class VistaCajero.
     */
    @Test
    public void testImprimirBoleta() {
        System.out.println("imprimirBoleta");
        VistaCajero instance = new VistaCajero();
        instance.imprimirBoleta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarVenta method, of class VistaCajero.
     */
    @Test
    public void testInsertarVenta() {
        System.out.println("insertarVenta");
        VistaCajero instance = new VistaCajero();
        instance.insertarVenta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarVenta method, of class VistaCajero.
     */
    @Test
    public void testBuscarVenta() {
        System.out.println("buscarVenta");
        String rut_cli = "";
        VistaCajero instance = new VistaCajero();
        instance.buscarVenta(rut_cli);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
