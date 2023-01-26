/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.MetodoPago;
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
public class NegocioMetodoPagoTest {
    
    public NegocioMetodoPagoTest() {
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
     * Test of configurarConexion method, of class NegocioMetodoPago.
     */
    @Test
    public void testConfigurarConexion() {
        System.out.println("configurarConexion");
        NegocioMetodoPago instance = new NegocioMetodoPago();
        instance.configurarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarMetodoPago method, of class NegocioMetodoPago.
     */
    @Test
    public void testInsertarMetodoPago() {
        System.out.println("insertarMetodoPago");
        MetodoPago metodopago = new MetodoPago();
        NegocioMetodoPago instance = new NegocioMetodoPago();
        instance.insertarMetodoPago(metodopago);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarMetodoPago method, of class NegocioMetodoPago.
     */
    @Test
    public void testActualizarMetodoPago() {
        System.out.println("actualizarMetodoPago");
        MetodoPago metodopago = new MetodoPago();
        NegocioMetodoPago instance = new NegocioMetodoPago();
        instance.actualizarMetodoPago(metodopago);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarMetodoPago method, of class NegocioMetodoPago.
     */
    @Test
    public void testEliminarMetodoPago() {
        System.out.println("eliminarMetodoPago");
        int id_metodo_pago = 20;
        NegocioMetodoPago instance = new NegocioMetodoPago();
        instance.eliminarMetodoPago(id_metodo_pago);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of getConec1 method, of class NegocioMetodoPago.
     */
    @Test
    public void testGetConec1() {
        System.out.println("getConec1");
        NegocioMetodoPago instance = new NegocioMetodoPago();
        ConexionMySQL expResult = null;
        ConexionMySQL result = instance.getConec1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setConec1 method, of class NegocioMetodoPago.
     */
    @Test
    public void testSetConec1() {
        System.out.println("setConec1");
        ConexionMySQL conec1 = null;
        NegocioMetodoPago instance = new NegocioMetodoPago();
        instance.setConec1(conec1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
