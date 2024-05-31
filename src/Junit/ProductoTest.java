package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domain.Producto;

public class ProductoTest {


    private Producto producto;

    @Before
    public void setUp() {
        // Reset the static contadorProducto before each test
        Producto.setContadorProducto(111);
        // Create a new instance of Producto and initialize attributes before each test
        producto = new Producto(111, "Producto Inicial", 50.0, false) {};
    }

    @Test
    public void testGetContadorProducto() {
        assertEquals(111, Producto.getContadorProducto());
    }

    @Test
    public void testSetContadorProducto() {
        Producto.setContadorProducto(200);
        assertEquals(200, Producto.getContadorProducto());
    }

    @Test
    public void testSetId() {
        producto.setId(222);
        assertEquals(222, producto.getId());
    }

    @Test
    public void testGetId() {
        assertEquals(111, producto.getId());
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Producto Inicial", producto.getTitulo());
    }

    @Test
    public void testSetTitulo() {
        producto.setTitulo("Nuevo Titulo");
        assertEquals("Nuevo Titulo", producto.getTitulo());
    }

    @Test
    public void testGetPrecio() {
        assertEquals(50.0, producto.getPrecio(), 0.0);
    }

    @Test
    public void testSetPrecio() {
        producto.setPrecio(200.0);
        assertEquals(200.0, producto.getPrecio(), 0.0);
    }

    @Test
    public void testIsAlquilado() {
        assertFalse(producto.isAlquilado());
    }

    @Test
    public void testSetAlquilado() {
        producto.setAlquilado(true);
        assertTrue(producto.isAlquilado());
    }

    @Test
    public void testToString() {
        producto.setTitulo("Test Titulo");
        producto.setPrecio(100.0);
        producto.setAlquilado(true);
        String resultadoEsperado = "Producto [id=111, titulo=Test Titulo, precio=100.0]";
        assertEquals(resultadoEsperado, producto.toString());
    }
}

