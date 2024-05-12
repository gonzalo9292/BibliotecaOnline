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
import gui.VentanaPrincipal;

public class main {
	
	public static List<Usuario> listaUsuarios ;
	public static Map<String,List<Producto>> mapaProductosUsuario= new HashMap<>();// Se rellena con la bd
	public static Map<String,List<Libro>> mapaLibrosUsuario= new HashMap<>();
	public static Map<String,List<Juego>> mapaJuegosUsuario= new HashMap<>();
	public static Map<String,List<Pelicula>> mapaPeliculasUsuario= new HashMap<>();
	
	
 	
	public main() {
		//listaUsuarios = DBManager.obtenerUsuarios();
		new VentanaPrincipal();
		listaUsuarios = DBManager.obtenerTodosLosUsuarios();
	    imprimirLista(listaUsuarios);
	    for(Usuario u : listaUsuarios) {
	    	List<Producto> listaProductosUsuario = DBManager.actualizarMapaUsuario(u.getNombreUsuario());
	    	mapaProductosUsuario.putIfAbsent(u.getNombreUsuario(),u.getListaProductos());
	    	mapaProductosUsuario.put(u.getNombreUsuario(), u.getListaProductos());
	    	mapaProductosUsuario.get(u.getNombreUsuario()).addAll(listaProductosUsuario);
	    }
	    System.out.println(mapaProductosUsuario);
	    
		
		
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

