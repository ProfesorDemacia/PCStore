/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.SolicitudVenta;
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
public class NegocioSolicitudVentaTest {
    
    public NegocioSolicitudVentaTest() {
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
     * Test of configurarConexion method, of class NegocioSolicitudVenta.
     */
    @Test
    public void testConfigurarConexion() {
        System.out.println("configurarConexion");
        NegocioSolicitudVenta instance = new NegocioSolicitudVenta();
        instance.configurarConexion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarSolicitudVenta method, of class NegocioSolicitudVenta.
     */
    @Test
    public void testInsertarSolicitudVenta() {
        System.out.println("insertarSolicitudVenta");
        SolicitudVenta solicitudventa = null;
        NegocioSolicitudVenta instance = new NegocioSolicitudVenta();
        instance.insertarSolicitudVenta(solicitudventa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarSolicitudVenta method, of class NegocioSolicitudVenta.
     */
    @Test
    public void testEliminarSolicitudVenta() {
        System.out.println("eliminarSolicitudVenta");
        int folio_detalle_venta = 0;
        NegocioSolicitudVenta instance = new NegocioSolicitudVenta();
        instance.eliminarSolicitudVenta(folio_detalle_venta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarSolicitudVenta method, of class NegocioSolicitudVenta.
     */
    @Test
    public void testBuscarSolicitudVenta() {
        System.out.println("buscarSolicitudVenta");
        String rut_cli = "";
        NegocioSolicitudVenta instance = new NegocioSolicitudVenta();
        SolicitudVenta expResult = null;
        SolicitudVenta result = instance.buscarSolicitudVenta(rut_cli);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuario method, of class NegocioSolicitudVenta.
     */
    @Test
    public void testExisteUsuario() {
        System.out.println("existeUsuario");
        String rut_cli = "";
        NegocioSolicitudVenta instance = new NegocioSolicitudVenta();
        boolean expResult = false;
        boolean result = instance.existeUsuario(rut_cli);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConec1 method, of class NegocioSolicitudVenta.
     */
    @Test
    public void testGetConec1() {
        System.out.println("getConec1");
        NegocioSolicitudVenta instance = new NegocioSolicitudVenta();
        ConexionMySQL expResult = null;
        ConexionMySQL result = instance.getConec1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConec1 method, of class NegocioSolicitudVenta.
     */
    @Test
    public void testSetConec1() {
        System.out.println("setConec1");
        ConexionMySQL conec1 = null;
        NegocioSolicitudVenta instance = new NegocioSolicitudVenta();
        instance.setConec1(conec1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
