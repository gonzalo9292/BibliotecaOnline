package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usuario {
	
	
	private String dni;
	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String contrase�a;
	private List<Producto> listaProductos=  new ArrayList<>();;

	
	


	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProducto(Producto p) {
		this.listaProductos.add(p);
	}
	public void setListaProductos(List<Producto> lista) {
		this.listaProductos.addAll(lista);
	}
	public Usuario(String dni, String nombre, String apellidos,  String nombreUsuario, String contrase�a) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;

		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
		
	}
	public Usuario() {
		
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	



	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos 
				+ ", nombreUsuario=" + nombreUsuario + ", contrase�a=" + contrase�a + "]";
	}



	
	
	
	

}
