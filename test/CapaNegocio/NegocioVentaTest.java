/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Venta;
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
public class NegocioVentaTest {
    
    public NegocioVentaTest() {
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
     * Test of configurarConexion method, of class NegocioVenta.
     */
    @Test
    public void testConfigurarConexion() {
        System.out.println("configurarConexion");
        NegocioVenta instance = new NegocioVenta();
        instance.configurarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarVenta method, of class NegocioVenta.
     */
    @Test
    public void testInsertarVenta() {
        System.out.println("insertarVenta");
        Venta venta = new Venta();
        NegocioVenta instance = new NegocioVenta();
        instance.insertarVenta(venta);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarVenta method, of class NegocioVenta.
     */
    @Test
    public void testEliminarVenta() {
        System.out.println("eliminarVenta");
        int id_venta = 12;
        NegocioVenta instance = new NegocioVenta();
        instance.eliminarVenta(id_venta);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of consultaVenta method, of class NegocioVenta.
     */
    @Test
    public void testConsultaVenta() {
        System.out.println("consultaVenta");
        NegocioVenta instance = new NegocioVenta();
        ArrayList<Venta> expResult = instance.consultaVenta();
        ArrayList<Venta> result = instance.consultaVenta();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of consultaVentaEspecifa method, of class NegocioVenta.
     */
    @Test
    public void testConsultaVentaEspecifa() {
        System.out.println("consultaVentaEspecifa");
        int id_venta = 0;
        NegocioVenta instance = new NegocioVenta();
        ArrayList<Venta> expResult = null;
        ArrayList<Venta> result = instance.consultaVentaEspecifa(id_venta);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of consultaVentaPorFecha method, of class NegocioVenta.
     */
    @Test
    public void testConsultaVentaPorFecha() {
        System.out.println("consultaVentaPorFecha");
        String fecha = "";
        NegocioVenta instance = new NegocioVenta();
        ArrayList<Venta> expResult = null;
        ArrayList<Venta> result = instance.consultaVentaPorFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of existeVenta method, of class NegocioVenta.
     */
    @Test
    public void testExisteVenta() {
        System.out.println("existeVenta");
        int id_venta = 3;
        NegocioVenta instance = new NegocioVenta();
        boolean expResult = false;
        boolean result = instance.existeVenta(id_venta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of getConec1 method, of class NegocioVenta.
     */
    @Test
    public void testGetConec1() {
        System.out.println("getConec1");
        NegocioVenta instance = new NegocioVenta();
        ConexionMySQL expResult = null;
        ConexionMySQL result = instance.getConec1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setConec1 method, of class NegocioVenta.
     */
    @Test
    public void testSetConec1() {
        System.out.println("setConec1");
        ConexionMySQL conec1 = null;
        NegocioVenta instance = new NegocioVenta();
        instance.setConec1(conec1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
