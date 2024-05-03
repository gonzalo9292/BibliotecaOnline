package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;


import db.DBManager;
import domain.Usuario;
import gui.VentanaPrincipal;

public class main {
	
	public static List<Usuario> listaUsuarios ;
	
	public main() {
		//listaUsuarios = DBManager.obtenerUsuarios();
		new VentanaPrincipal();
		
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

