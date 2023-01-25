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
public class VistaCategoriasTest {
    
    public VistaCategoriasTest() {
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
     * Test of buscarCategoriaID method, of class VistaCategorias.
     */
    @Test
    public void testBuscarCategoriaID() {
        System.out.println("buscarCategoriaID");
        String id_cate = "";
        VistaCategorias instance = new VistaCategorias();
        instance.buscarCategoriaID(id_cate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarListadoCategoria method, of class VistaCategorias.
     */
    @Test
    public void testCargarListadoCategoria() {
        System.out.println("cargarListadoCategoria");
        VistaCategorias instance = new VistaCategorias();
        instance.cargarListadoCategoria();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
