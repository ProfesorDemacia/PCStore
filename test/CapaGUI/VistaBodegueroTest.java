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
public class VistaBodegueroTest {
    
    public VistaBodegueroTest() {
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
     * Test of buscarCategoria method, of class VistaBodeguero.
     */
    @Test
    public void testBuscarCategoria() {
        System.out.println("buscarCategoria");
        int id_categoria_prod = 0;
        VistaBodeguero instance = new VistaBodeguero();
        instance.buscarCategoria(id_categoria_prod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarProductoID method, of class VistaBodeguero.
     */
    @Test
    public void testBuscarProductoID() {
        System.out.println("buscarProductoID");
        String cod_prod = "";
        VistaBodeguero instance = new VistaBodeguero();
        instance.buscarProductoID(cod_prod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarListadoDeProductos method, of class VistaBodeguero.
     */
    @Test
    public void testCargarListadoDeProductos() {
        System.out.println("cargarListadoDeProductos");
        VistaBodeguero instance = new VistaBodeguero();
        instance.cargarListadoDeProductos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of codProd method, of class VistaBodeguero.
     */
    @Test
    public void testCodProd() {
        System.out.println("codProd");
        VistaBodeguero instance = new VistaBodeguero();
        instance.codProd();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarStock method, of class VistaBodeguero.
     */
    @Test
    public void testValidarStock() {
        System.out.println("validarStock");
        VistaBodeguero instance = new VistaBodeguero();
        instance.validarStock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
