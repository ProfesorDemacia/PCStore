/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySQL;
import CapaDTO.TipoUsuario;
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
public class NegocioTipoUsuarioTest {
    
    public NegocioTipoUsuarioTest() {
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
     * Test of configurarConexion method, of class NegocioTipoUsuario.
     */
    @Test
    public void testConfigurarConexion() {
        System.out.println("configurarConexion");
        NegocioTipoUsuario instance = new NegocioTipoUsuario();
        instance.configurarConexion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarTipoUsuario method, of class NegocioTipoUsuario.
     */
    @Test
    public void testInsertarTipoUsuario() {
        System.out.println("insertarTipoUsuario");
        TipoUsuario tipousuario = null;
        NegocioTipoUsuario instance = new NegocioTipoUsuario();
        instance.insertarTipoUsuario(tipousuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarTipoUsuario method, of class NegocioTipoUsuario.
     */
    @Test
    public void testActualizarTipoUsuario() {
        System.out.println("actualizarTipoUsuario");
        TipoUsuario tipousuario = null;
        NegocioTipoUsuario instance = new NegocioTipoUsuario();
        instance.actualizarTipoUsuario(tipousuario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarTipoUsuario method, of class NegocioTipoUsuario.
     */
    @Test
    public void testEliminarTipoUsuario() {
        System.out.println("eliminarTipoUsuario");
        String id_tipo_usu = "";
        NegocioTipoUsuario instance = new NegocioTipoUsuario();
        instance.eliminarTipoUsuario(id_tipo_usu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultaTipoUsuario method, of class NegocioTipoUsuario.
     */
    @Test
    public void testConsultaTipoUsuario() {
        System.out.println("consultaTipoUsuario");
        NegocioTipoUsuario instance = new NegocioTipoUsuario();
        ArrayList<TipoUsuario> expResult = null;
        ArrayList<TipoUsuario> result = instance.consultaTipoUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscaTipoUsuario method, of class NegocioTipoUsuario.
     */
    @Test
    public void testBuscaTipoUsuario() {
        System.out.println("buscaTipoUsuario");
        int id_tipo_usu = 0;
        NegocioTipoUsuario instance = new NegocioTipoUsuario();
        TipoUsuario expResult = null;
        TipoUsuario result = instance.buscaTipoUsuario(id_tipo_usu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConec1 method, of class NegocioTipoUsuario.
     */
    @Test
    public void testGetConec1() {
        System.out.println("getConec1");
        NegocioTipoUsuario instance = new NegocioTipoUsuario();
        ConexionMySQL expResult = null;
        ConexionMySQL result = instance.getConec1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConec1 method, of class NegocioTipoUsuario.
     */
    @Test
    public void testSetConec1() {
        System.out.println("setConec1");
        ConexionMySQL conec1 = null;
        NegocioTipoUsuario instance = new NegocioTipoUsuario();
        instance.setConec1(conec1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
