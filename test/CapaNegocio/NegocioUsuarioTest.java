/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.Usuario;
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
public class NegocioUsuarioTest {
    
    public NegocioUsuarioTest() {
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
     * Test of configurarConexion method, of class NegocioUsuario.
     */
    @Test
    public void testConfigurarConexion() {
        System.out.println("configurarConexion");
        NegocioUsuario instance = new NegocioUsuario();
        instance.configurarConexion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of insertarUsuario method, of class NegocioUsuario.
     */
    @Test
    public void testInsertarUsuario() {
        System.out.println("insertarUsuario");
        Usuario usuario = new Usuario();
        NegocioUsuario instance = new NegocioUsuario();
        instance.insertarUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarUsuario method, of class NegocioUsuario.
     */
    @Test
    public void testActualizarUsuario() {
        System.out.println("actualizarUsuario");
        Usuario usuario = new Usuario();
        NegocioUsuario instance = new NegocioUsuario();
        instance.actualizarUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarUsuario method, of class NegocioUsuario.
     */
    @Test
    public void testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        String rut_usu = "19999999-9";
        NegocioUsuario instance = new NegocioUsuario();
        instance.eliminarUsuario(rut_usu);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of consultarCargo method, of class NegocioUsuario.
     */
    @Test
    public void testConsultarCargo() {
        System.out.println("consultarCargo");
        String rut_usu = "19890682-4";
        NegocioUsuario instance = new NegocioUsuario();
        int expResult = 4;
        int result = instance.consultarCargo(rut_usu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuario method, of class NegocioUsuario.
     */
    @Test
    public void testExisteUsuario() {
        System.out.println("existeUsuario");
        String rut_usu = "19890682-4";
        NegocioUsuario instance = new NegocioUsuario();
        boolean expResult = instance.existeUsuario(rut_usu);
        boolean result = instance.existeUsuario(rut_usu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getConec1 method, of class NegocioUsuario.
     */
    @Test
    public void testGetConec1() {
        System.out.println("getConec1");
        NegocioUsuario instance = new NegocioUsuario();
        ConexionMySQL expResult = null;
        ConexionMySQL result = instance.getConec1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setConec1 method, of class NegocioUsuario.
     */
    @Test
    public void testSetConec1() {
        System.out.println("setConec1");
        ConexionMySQL conec1 = null;
        NegocioUsuario instance = new NegocioUsuario();
        instance.setConec1(conec1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
