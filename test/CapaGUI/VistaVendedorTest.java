/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaGUI;

import javax.swing.JTable;
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
public class VistaVendedorTest {
    
    public VistaVendedorTest() {
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
     * Test of buscarProducto method, of class VistaVendedor.
     */
    @Test
    public void testBuscarProducto() {
        System.out.println("buscarProducto");
        VistaVendedor instance = new VistaVendedor();
        instance.buscarProducto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarDatos method, of class VistaVendedor.
     */
    @Test
    public void testLimpiarDatos() {
        System.out.println("limpiarDatos");
        VistaVendedor instance = new VistaVendedor();
        instance.limpiarDatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarTabla method, of class VistaVendedor.
     */
    @Test
    public void testLimpiarTabla() {
        System.out.println("limpiarTabla");
        VistaVendedor instance = new VistaVendedor();
        instance.limpiarTabla();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeIdProducto method, of class VistaVendedor.
     */
    @Test
    public void testExisteIdProducto() {
        System.out.println("existeIdProducto");
        JTable jtable = null;
        int id_prod = 0;
        int colum = 0;
        VistaVendedor instance = new VistaVendedor();
        boolean expResult = false;
        boolean result = instance.existeIdProducto(jtable, id_prod, colum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarTabla method, of class VistaVendedor.
     */
    @Test
    public void testAgregarTabla() {
        System.out.println("agregarTabla");
        JTable jtable = null;
        String id_prod = "";
        VistaVendedor instance = new VistaVendedor();
        instance.agregarTabla(jtable, id_prod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarDetalleVenta method, of class VistaVendedor.
     */
    @Test
    public void testGuardarDetalleVenta() {
        System.out.println("guardarDetalleVenta");
        VistaVendedor instance = new VistaVendedor();
        instance.guardarDetalleVenta();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarProducto method, of class VistaVendedor.
     */
    @Test
    public void testEliminarProducto() {
        System.out.println("eliminarProducto");
        VistaVendedor instance = new VistaVendedor();
        instance.eliminarProducto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarStock method, of class VistaVendedor.
     */
    @Test
    public void testValidarStock() {
        System.out.println("validarStock");
        VistaVendedor instance = new VistaVendedor();
        instance.validarStock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
