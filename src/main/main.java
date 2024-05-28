package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingUtilities;


import db.DBManager;
import domain.Juego;
import domain.Libro;
import domain.Pelicula;
import domain.Producto;
import domain.Usuario;
import gui.DevolverProductos;
import gui.VentanaPrincipal;

public class main {
	
	
	public static Map<String,List<Libro>> mapaLibrosUsuario= new HashMap<>();
	public static Map<String,List<Juego>> mapaJuegosUsuario= new HashMap<>();
	public static Map<String,List<Pelicula>> mapaPeliculasUsuario= new HashMap<>();
	
	
 	
	public main() {
		//listaUsuarios = DBManager.obtenerUsuarios();
		new VentanaPrincipal();
		
		List<Usuario> listaUsuarios = DBManager.obtenerTodosLosUsuarios();
		
		for(Usuario u : listaUsuarios) {
			System.out.println(String.format("El usuario %s tiene estos productos:", u.getNombreUsuario()));
			u.setListaProductos(DBManager.ListaMapaUsuario(u.getNombreUsuario()));
			for(Producto p : u.getListaProductos()) {
				System.out.println(p);
			}
		}
	
	   
	    
		
		
	}
	
	
	public void imprimirLista(List<Usuario> lista) {
		for(Usuario u : lista) {
			System.out.println(u.getNombreUsuario());
		}
	}
	
   public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new main();
				
			
			}
		});
	}
   
   
 }	

