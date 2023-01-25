/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Producto;
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
public class NegocioProductoTest {
    
    public NegocioProductoTest() {
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
     * Test of configurarConexion method, of class NegocioProducto.
     */
    @Test
    public void testConfigurarConexion() {
        System.out.println("configurarConexion");
        NegocioProducto instance = new NegocioProducto();
        instance.configurarConexion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarProducto method, of class NegocioProducto.
     */
    @Test
    public void testInsertarProducto() {
        System.out.println("insertarProducto");
        Producto producto = null;
        NegocioProducto instance = new NegocioProducto();
        instance.insertarProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarProducto method, of class NegocioProducto.
     */
    @Test
    public void testActualizarProducto() {
        System.out.println("actualizarProducto");
        Producto producto = null;
        NegocioProducto instance = new NegocioProducto();
        instance.actualizarProducto(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SumarStockDeProducto method, of class NegocioProducto.
     */
    @Test
    public void testSumarStockDeProducto() {
        System.out.println("SumarStockDeProducto");
        int id_prod = 0;
        int cantidad = 0;
        NegocioProducto instance = new NegocioProducto();
        instance.SumarStockDeProducto(id_prod, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DisminuirStockDeProducto method, of class NegocioProducto.
     */
    @Test
    public void testDisminuirStockDeProducto() {
        System.out.println("DisminuirStockDeProducto");
        int id_prod = 0;
        int cantidad = 0;
        NegocioProducto instance = new NegocioProducto();
        instance.DisminuirStockDeProducto(id_prod, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarProducto method, of class NegocioProducto.
     */
    @Test
    public void testEliminarProducto() {
        System.out.println("eliminarProducto");
        int id_prod = 0;
        NegocioProducto instance = new NegocioProducto();
        instance.eliminarProducto(id_prod);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultaProducto method, of class NegocioProducto.
     */
    @Test
    public void testConsultaProducto() {
        System.out.println("consultaProducto");
        NegocioProducto instance = new NegocioProducto();
        ArrayList<Producto> expResult = null;
        ArrayList<Producto> result = instance.consultaProducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaProducto method, of class NegocioProducto.
     */
    @Test
    public void testBuscaProducto() {
        System.out.println("buscaProducto");
        int id_prod = 0;
        NegocioProducto instance = new NegocioProducto();
        Producto expResult = null;
        Producto result = instance.buscaProducto(id_prod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorCategoria method, of class NegocioProducto.
     */
    @Test
    public void testBuscarPorCategoria() {
        System.out.println("buscarPorCategoria");
        int id_categoria = 0;
        NegocioProducto instance = new NegocioProducto();
        ArrayList<Producto> expResult = null;
        ArrayList<Producto> result = instance.buscarPorCategoria(id_categoria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeProducto method, of class NegocioProducto.
     */
    @Test
    public void testExisteProducto() {
        System.out.println("existeProducto");
        int id_prod = 0;
        NegocioProducto instance = new NegocioProducto();
        boolean expResult = false;
        boolean result = instance.existeProducto(id_prod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConec1 method, of class NegocioProducto.
     */
    @Test
    public void testGetConec1() {
        System.out.println("getConec1");
        NegocioProducto instance = new NegocioProducto();
        ConexionMySQL expResult = null;
        ConexionMySQL result = instance.getConec1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConec1 method, of class NegocioProducto.
     */
    @Test
    public void testSetConec1() {
        System.out.println("setConec1");
        ConexionMySQL conec1 = null;
        NegocioProducto instance = new NegocioProducto();
        instance.setConec1(conec1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
