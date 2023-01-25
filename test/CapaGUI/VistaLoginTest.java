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
public class VistaLoginTest {
    
    public VistaLoginTest() {
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
     * Test of validarUsuario method, of class VistaLogin.
     */
    @Test
    public void testValidarUsuario() {
        System.out.println("validarUsuario");
        VistaLogin instance = new VistaLogin();
        instance.validarUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redireccionarVentana method, of class VistaLogin.
     */
    @Test
    public void testRedireccionarVentana() {
        System.out.println("redireccionarVentana");
        String rut_usu = "";
        VistaLogin instance = new VistaLogin();
        instance.redireccionarVentana(rut_usu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of redireccionarCerrar method, of class VistaLogin.
     */
    @Test
    public void testRedireccionarCerrar() {
        System.out.println("redireccionarCerrar");
        String rut_usu = "";
        VistaLogin instance = new VistaLogin();
        instance.redireccionarCerrar(rut_usu);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
