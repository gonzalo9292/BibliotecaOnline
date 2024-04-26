package main;

import javax.swing.SwingUtilities;

import domain.Usuario;
import gui.VentanaPrincipal;

public class main {
	
	public static Usuario u = new Usuario();
	
	public main() {
		// TODO Auto-generated constructor stub
		
		
	SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaPrincipal();
				
			}
		});
				}
		
	

}
