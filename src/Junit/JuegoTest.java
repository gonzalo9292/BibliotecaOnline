package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domain.Juego;

public class JuegoTest {

    private Juego juego;

    @Before
    public void setUp() {
        // Creamos una nueva instancia de Juego y establecemos sus atributos antes de cada prueba
        juego = new Juego(111, "Juego Inicial", 40.0, false, "Compañía Inicial", "Plataforma Inicial");
    }

    @Test
    public void testGetCompania() {
        assertEquals("Compañía Inicial", juego.getCompania());
    }

    @Test
    public void testSetCompania() {
        juego.setCompania("Nueva Compañía");
        assertEquals("Nueva Compañía", juego.getCompania());
    }

    @Test
    public void testGetPlataforma() {
        assertEquals("Plataforma Inicial", juego.getPlataforma());
    }

    @Test
    public void testSetPlataforma() {
        juego.setPlataforma("Nueva Plataforma");
        assertEquals("Nueva Plataforma", juego.getPlataforma());
    }

    @Test
    public void testGetId() {
        assertEquals(111, juego.getId());
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Juego Inicial", juego.getTitulo());
    }

    @Test
    public void testSetTitulo() {
        juego.setTitulo("Nuevo Título");
        assertEquals("Nuevo Título", juego.getTitulo());
    }

    @Test
    public void testGetPrecio() {
        assertEquals(40.0, juego.getPrecio(), 0.0);
    }

    @Test
    public void testSetPrecio() {
        juego.setPrecio(50.0);
        assertEquals(50.0, juego.getPrecio(), 0.0);
    }

    @Test
    public void testIsAlquilado() {
        assertFalse(juego.isAlquilado());
    }

    @Test
    public void testSetAlquilado() {
        juego.setAlquilado(true);
        assertTrue(juego.isAlquilado());
    }

    @Test
    public void testToString() {
        juego.setTitulo("Test Titulo");
        juego.setPrecio(100.0);
        juego.setAlquilado(true);
        juego.setCompania("Test Compañia");
        juego.setPlataforma("Test Plataforma");
        String expected = "Juego [compania=Test Compañia, plataforma=Test Plataforma, getId()=111, getTitulo()=Test Titulo, getPrecio()=100.0]";
        assertEquals(expected, juego.toString());
    }

}
