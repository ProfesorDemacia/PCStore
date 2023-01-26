/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.CategoriaProducto;
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
public class NegocioCategoriaProductoTest {
    
    public NegocioCategoriaProductoTest() {
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
     * Test of configurarConexion method, of class NegocioCategoriaProducto.
     */
    @Test
    public void testConfigurarConexion() {
        System.out.println("configurarConexion");
        NegocioCategoriaProducto instance = new NegocioCategoriaProducto();
        instance.configurarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarCategoriaProducto method, of class NegocioCategoriaProducto.
     */
    @Test
    public void testInsertarCategoriaProducto() {
        System.out.println("insertarCategoriaProducto");
        CategoriaProducto instance2 = new CategoriaProducto();
        NegocioCategoriaProducto instance = new NegocioCategoriaProducto();
        instance.insertarCategoriaProducto(instance2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarCategoriaProducto method, of class NegocioCategoriaProducto.
     */
    @Test
    public void testActualizarCategoriaProducto() {
        System.out.println("actualizarCategoriaProducto");
        CategoriaProducto instance2 = new CategoriaProducto() ;
        NegocioCategoriaProducto instance = new NegocioCategoriaProducto();
        instance.actualizarCategoriaProducto(instance2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarCategoriaProducto method, of class NegocioCategoriaProducto.
     */
    @Test
    public void testEliminarCategoriaProducto() {
        System.out.println("eliminarCategoriaProducto");
        int id_categoria_prod = 16;
        NegocioCategoriaProducto instance = new NegocioCategoriaProducto();
        instance.eliminarCategoriaProducto(id_categoria_prod);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    

    /**
     * Test of existeCategoria method, of class NegocioCategoriaProducto.
     */
    @Test
    public void testExisteCategoria() {
        System.out.println("existeCategoria");
        int id_cat = 10;
        NegocioCategoriaProducto instance = new NegocioCategoriaProducto();
        boolean expResult = instance.existeCategoria(id_cat);
        boolean result = instance.existeCategoria(id_cat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getConec1 method, of class NegocioCategoriaProducto.
     */
    @Test
    public void testGetConec1() {
        System.out.println("getConec1");
        NegocioCategoriaProducto instance = new NegocioCategoriaProducto();
        ConexionMySQL expResult = null;
        ConexionMySQL result = instance.getConec1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setConec1 method, of class NegocioCategoriaProducto.
     */
    @Test
    public void testSetConec1() {
        System.out.println("setConec1");
        ConexionMySQL conec1 = null;
        NegocioCategoriaProducto instance = new NegocioCategoriaProducto();
        instance.setConec1(conec1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
