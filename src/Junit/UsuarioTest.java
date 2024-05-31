package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Juego;
import domain.Libro;
import domain.Pelicula;
import domain.Producto;
import domain.Usuario;

public class UsuarioTest {

    private Usuario usuario;
    private Libro libro ;
    private Juego juego;
    private Pelicula pelicula;
   
   


    @Before
    public void setUp() {
        usuario = new Usuario("12345678A", "Gonzalo", "Arroyo", "gonzaloarroyo", "password123");
        libro = new Libro(2, "El Señor de los Anillos", 29.99, true, "J.R.R. Tolkien", 1178);
        juego = new Juego(1, "The Witcher 3: Wild Hunt", 59.99, false, "CD Projekt Red", "PlayStation 4");
        pelicula = new Pelicula(3, "El Padrino", 14.99, false, "Francis Ford Coppola", 175);


   
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
      usuario.setListaProducto(libro);
       usuario.setListaProducto(juego);
       usuario.setListaProducto(pelicula);
       List<Producto> productos = usuario.getListaProductos();
       assertEquals(3, productos.size());
       assertTrue(productos.contains(libro));
       assertTrue(productos.contains(juego));
       assertTrue(productos.contains(pelicula));
 
   }

   @Test
   public void testSetListaProductos() {
       List<Producto> nuevosProductos = new ArrayList<>();
       usuario.setListaProducto(libro);
       usuario.setListaProducto(juego);
       usuario.setListaProducto(pelicula);
       usuario.setListaProductos(nuevosProductos);
       List<Producto> productos = usuario.getListaProductos();
       assertEquals(3, productos.size());
       assertTrue(productos.contains(libro));
       assertTrue(productos.contains(juego));
       assertTrue(productos.contains(pelicula));
   }

   @Test
   public void testToString() {
       String expected = "Usuario [dni=12345678A, nombre=Gonzalo, apellidos=Arroyo, nombreUsuario=gonzaloarroyo, contraseña=password123]";
       assertEquals(expected, usuario.toString());
   }
}

