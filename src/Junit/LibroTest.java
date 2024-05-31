package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domain.Libro;

public class LibroTest {

    private Libro libro;

    @Before
    public void setUp() {
        // Create a new instance of Libro and initialize attributes before each test
        libro = new Libro(111, "Libro Inicial", 30.0, false, "Autor Inicial", 300);
    }

    @Test
    public void testGetAutor() {
        assertEquals("Autor Inicial", libro.getAutor());
    }

    @Test
    public void testSetAutor() {
        libro.setAutor("Nuevo Autor");
        assertEquals("Nuevo Autor", libro.getAutor());
    }

    @Test
    public void testGetNumPaginas() {
        assertEquals(300, libro.getNumPaginas());
    }

    @Test
    public void testSetNumPaginas() {
        libro.setNumPaginas(400);
        assertEquals(400, libro.getNumPaginas());
    }

    @Test
    public void testGetId() {
        assertEquals(111, libro.getId());
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Libro Inicial", libro.getTitulo());
    }

    @Test
    public void testSetTitulo() {
        libro.setTitulo("Nuevo Titulo");
        assertEquals("Nuevo Titulo", libro.getTitulo());
    }

    @Test
    public void testGetPrecio() {
        assertEquals(30.0, libro.getPrecio(), 0.0);
    }

    @Test
    public void testSetPrecio() {
        libro.setPrecio(45.0);
        assertEquals(45.0, libro.getPrecio(), 0.0);
    }

    @Test
    public void testIsAlquilado() {
        assertFalse(libro.isAlquilado());
    }

    @Test
    public void testSetAlquilado() {
        libro.setAlquilado(true);
        assertTrue(libro.isAlquilado());
    }

    @Test
    public void testToString() {
        libro.setTitulo("Test Titulo");
        libro.setPrecio(100.0);
        libro.setAlquilado(true);
        libro.setAutor("Test Autor");
        libro.setNumPaginas(130);
        String expected = "Libro [autor=Test Autor, numero_Paginas=130, getId()=111, getTitulo()=Test Titulo, getPrecio()=100.0]";
        assertEquals(expected, libro.toString());
    }

}
