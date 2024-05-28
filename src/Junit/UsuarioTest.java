package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Producto;
import domain.Usuario;

public class UsuarioTest {

    private Usuario usuario;
    //private Producto producto1 = new Producto;
    private Producto producto2;

    @Before
    public void setUp() {
        usuario = new Usuario("12345678A", "Gonzalo", "Arroyo", "gonzaloarroyo", "password123");
    //    producto1 = new Producto(1, "Producto 1", 10.0, true);
     //   producto2 = new Producto(2, "Producto 2", 20.0, false);
    }

    @Test
    public void testGetDni() {
        assertEquals("12345678A", usuario.getDni());
    }


	    @Test
	    public void testSetDni() {
	        usuario.setDni("87654321B");
	        assertEquals("87654321B", usuario.getDni());
	    }

	    @Test
	    public void testGetNombre() {
	        assertEquals("Gonzalo", usuario.getNombre());
	    }

	    @Test
	    public void testSetNombre() {
	        usuario.setNombre("Ana");
	        assertEquals("Ana", usuario.getNombre());
	    }

	    @Test
	    public void testGetApellidos() {
	        assertEquals("Arroyo", usuario.getApellidos());
	    }

	    @Test
	    public void testSetApellidos() {
	        usuario.setApellidos("García");
	        assertEquals("García", usuario.getApellidos());
	    }

	    @Test
	    public void testGetNombreUsuario() {
	        assertEquals("gonzaloarroyo", usuario.getNombreUsuario());
	    }

	    @Test
	    public void testSetNombreUsuario() {
	        usuario.setNombreUsuario("anagarcia");
	        assertEquals("anagarcia", usuario.getNombreUsuario());
	    }

	    @Test
	    public void testGetContraseña() {
	        assertEquals("password123", usuario.getContraseña());
	    }

	    @Test
	    public void testSetContraseña() {
	        usuario.setContraseña("newpassword123");
	        assertEquals("newpassword123", usuario.getContraseña());
	    }

	    @Test
	    public void testGetListaProductos() {
	        assertTrue(usuario.getListaProductos().isEmpty());
	    }

	    @Test
	    public void testSetListaProducto() {
	   //     usuario.setListaProducto(producto1);
	        usuario.setListaProducto(producto2);
	        List<Producto> productos = usuario.getListaProductos();
	        assertEquals(2, productos.size());
	    //    assertTrue(productos.contains(producto1));
	        assertTrue(productos.contains(producto2));
	    }

	    @Test
	    public void testSetListaProductos() {
	        List<Producto> nuevosProductos = new ArrayList<>();
	     //   nuevosProductos.add(producto1);
	        nuevosProductos.add(producto2);
	        usuario.setListaProductos(nuevosProductos);
	        List<Producto> productos = usuario.getListaProductos();
	        assertEquals(2, productos.size());
	     //   assertTrue(productos.contains(producto1));
	        assertTrue(productos.contains(producto2));
	    }

	    @Test
	    public void testToString() {
	        String expected = "Usuario [dni=12345678A, nombre=Gonzalo, apellidos=Arroyo, nombreUsuario=gonzaloarroyo, contraseña=password123]";
	        assertEquals(expected, usuario.toString());
	    }
}
