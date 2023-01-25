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
public class VistaListarProductoTest {
    
    public VistaListarProductoTest() {
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
     * Test of buscarProductoID method, of class VistaListarProducto.
     */
    @Test
    public void testBuscarProductoID() {
        System.out.println("buscarProductoID");
        String cod_prod = "";
        VistaListarProducto instance = new VistaListarProducto();
        instance.buscarProductoID(cod_prod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCategoria method, of class VistaListarProducto.
     */
    @Test
    public void testBuscarCategoria() {
        System.out.println("buscarCategoria");
        int id_categoria_prod = 0;
        VistaListarProducto instance = new VistaListarProducto();
        instance.buscarCategoria(id_categoria_prod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
