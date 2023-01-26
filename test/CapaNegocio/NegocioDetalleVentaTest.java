/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.DetalleVenta;
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
public class NegocioDetalleVentaTest {
    
    public NegocioDetalleVentaTest() {
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
     * Test of configurarConexion method, of class NegocioDetalleVenta.
     */
    @Test
    public void testConfigurarConexion() {
        System.out.println("configurarConexion");
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        instance.configurarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarDetalleVenta method, of class NegocioDetalleVenta.
     */
    @Test
    public void testInsertarDetalleVenta() {
        System.out.println("insertarDetalleVenta");
        DetalleVenta detalleventa = new DetalleVenta();
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        instance.insertarDetalleVenta(detalleventa);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarDetalleVenta method, of class NegocioDetalleVenta.
     */
    @Test
    public void testActualizarDetalleVenta() {
        System.out.println("actualizarDetalleVenta");
        DetalleVenta detalleventa = new DetalleVenta();
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        instance.actualizarDetalleVenta(detalleventa);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarDetalleVenta method, of class NegocioDetalleVenta.
     */
    @Test
    public void testEliminarDetalleVenta() {
        System.out.println("eliminarDetalleVenta");
        int folio_detalle_venta = 20;
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        instance.eliminarDetalleVenta(folio_detalle_venta);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of consultaDetalleVenta method, of class NegocioDetalleVenta.
     */
    @Test
    public void testConsultaDetalleVenta() {
        System.out.println("consultaDetalleVenta");
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        ArrayList<DetalleVenta> expResult = instance.consultaDetalleVenta();
        ArrayList<DetalleVenta> result = instance.consultaDetalleVenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of consultaDetalleVentaCarro method, of class NegocioDetalleVenta.
     */
    @Test
    public void testConsultaDetalleVentaCarro() {
        System.out.println("consultaDetalleVentaCarro");
        int folio = 1;
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        ArrayList<DetalleVenta> expResult = instance.consultaDetalleVentaCarro(folio);
        ArrayList<DetalleVenta> result = instance.consultaDetalleVentaCarro(folio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of sumarFolio method, of class NegocioDetalleVenta.
     */
    @Test
    public void testSumarFolio() {
        System.out.println("sumarFolio");
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        int expResult = instance.sumarFolio();
        int result = instance.sumarFolio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of encontrarFolio method, of class NegocioDetalleVenta.
     */
    @Test
    public void testEncontrarFolio() {
        System.out.println("encontrarFolio");
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        int expResult = 10;
        int result = instance.encontrarFolio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of encontrarFolioEspecifico method, of class NegocioDetalleVenta.
     */
    @Test
    public void testEncontrarFolioEspecifico() {
        System.out.println("encontrarFolioEspecifico");
        int id_detalle_venta = 3;
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        int expResult = 10;
        int result = instance.encontrarFolioEspecifico(id_detalle_venta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarIdDetalleVenta method, of class NegocioDetalleVenta.
     */
    @Test
    public void testBuscarIdDetalleVenta() {
        System.out.println("buscarIdDetalleVenta");
        int id_folio = 10;
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        int expResult = 3;
        int result = instance.buscarIdDetalleVenta(id_folio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getConec1 method, of class NegocioDetalleVenta.
     */
    @Test
    public void testGetConec1() {
        System.out.println("getConec1");
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        ConexionMySQL expResult = null;
        ConexionMySQL result = instance.getConec1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setConec1 method, of class NegocioDetalleVenta.
     */
    @Test
    public void testSetConec1() {
        System.out.println("setConec1");
        ConexionMySQL conec1 = null;
        NegocioDetalleVenta instance = new NegocioDetalleVenta();
        instance.setConec1(conec1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
