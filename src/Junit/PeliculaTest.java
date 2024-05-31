package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domain.Pelicula;

public class PeliculaTest {
	  private Pelicula pelicula;

	    @Before
	    public void setUp() {
	        // Create a new instance of Pelicula and initialize attributes before each test
	        pelicula = new Pelicula(111, "Pelicula Inicial", 50.0, false, "Director Inicial", 120);
	    }

	    @Test
	    public void testGetDirector() {
	        assertEquals("Director Inicial", pelicula.getDirector());
	    }

	    @Test
	    public void testSetDirector() {
	        pelicula.setDirector("Nuevo Director");
	        assertEquals("Nuevo Director", pelicula.getDirector());
	    }

	    @Test
	    public void testGetDuracion() {
	        assertEquals(120, pelicula.getDuracion());
	    }

	    @Test
	    public void testSetDuracion() {
	        pelicula.setDuracion(150);
	        assertEquals(150, pelicula.getDuracion());
	    }

	    @Test
	    public void testGetId() {
	        assertEquals(111, pelicula.getId());
	    }

	    @Test
	    public void testGetTitulo() {
	        assertEquals("Pelicula Inicial", pelicula.getTitulo());
	    }

	    @Test
	    public void testSetTitulo() {
	        pelicula.setTitulo("Nuevo Titulo");
	        assertEquals("Nuevo Titulo", pelicula.getTitulo());
	    }

	    @Test
	    public void testGetPrecio() {
	        assertEquals(50.0, pelicula.getPrecio(), 0.0);
	    }

	    @Test
	    public void testSetPrecio() {
	        pelicula.setPrecio(200.0);
	        assertEquals(200.0, pelicula.getPrecio(), 0.0);
	    }

	    @Test
	    public void testIsAlquilado() {
	        assertFalse(pelicula.isAlquilado());
	    }

	    @Test
	    public void testSetAlquilado() {
	        pelicula.setAlquilado(true);
	        assertTrue(pelicula.isAlquilado());
	    }

	    @Test
	    public void testToString() {
	        pelicula.setTitulo("Test Titulo");
	        pelicula.setPrecio(100.0);
	        pelicula.setAlquilado(true);
	        pelicula.setDirector("Test Director");
	        pelicula.setDuracion(130);
	        String expected = "Pelicula [director=Test Director, duracion=130, getId()=111, getTitulo()=Test Titulo, getPrecio()=100.0]";
	        assertEquals(expected, pelicula.toString());
	    }

}
