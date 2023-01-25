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
public class VistaUsuarioTest {
    
    public VistaUsuarioTest() {
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
     * Test of buscarUsuario method, of class VistaUsuario.
     */
    @Test
    public void testBuscarUsuario() {
        System.out.println("buscarUsuario");
        VistaUsuario instance = new VistaUsuario();
        instance.buscarUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuarioEspecifico method, of class VistaUsuario.
     */
    @Test
    public void testBuscarUsuarioEspecifico() {
        System.out.println("buscarUsuarioEspecifico");
        String rut_usu = "";
        VistaUsuario instance = new VistaUsuario();
        instance.buscarUsuarioEspecifico(rut_usu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarUsuario method, of class VistaUsuario.
     */
    @Test
    public void testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        VistaUsuario instance = new VistaUsuario();
        instance.eliminarUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarUsuario method, of class VistaUsuario.
     */
    @Test
    public void testMostrarUsuario() {
        System.out.println("mostrarUsuario");
        VistaUsuario instance = new VistaUsuario();
        instance.mostrarUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
