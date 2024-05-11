package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import db.DBManager;
import domain.Usuario;

public class VentanaIniciarSesion extends JFrame{

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private Usuario user;

 



public VentanaIniciarSesion(Usuario user) {
 
	
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(300, 300);
			setTitle("BibliotecaOnline");
		
	        setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
			
	        setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
			
	        this.user = user;
	
	   
	        
			JPanel panelIniciarSesion  = new JPanel();
			panelIniciarSesion.setBackground(Color.darkGray);
		
			JPanel panelBotones = new JPanel();
			JPanel userPass = new JPanel();
			JPanel pUsuario = new JPanel();
			JPanel pContraseña = new JPanel();
			userPass.setLayout(new GridLayout(2,1));
			
	
			JButton bInicioSecion = new JButton("Iniciar sesión");
		
			JTextField txtUsuario = new JTextField(20);
			JTextField txtContraseña = new JTextField(20);

			JLabel lIniciarSesion = new JLabel("Iniciar sesion");
			Font fuente = new Font("Arial",Font.BOLD,25);
	        lIniciarSesion.setFont(fuente);
	        lIniciarSesion.setForeground(Color.WHITE);
			JLabel lUsurario = new JLabel("   Usuario    ");
			JLabel lContraseña = new JLabel("Contraseña");
			
			
		
			add(panelIniciarSesion, BorderLayout.NORTH);
			panelIniciarSesion.add(lIniciarSesion, BorderLayout.CENTER);
	
			add(userPass,BorderLayout.CENTER);
			userPass.add(pUsuario);
			userPass.add(pContraseña);
			add(panelBotones,BorderLayout.SOUTH);
		
			pUsuario.add(lUsurario);
			pUsuario.add(txtUsuario);
			pContraseña.add(lContraseña);
			pContraseña.add(txtContraseña);
			panelBotones.add(bInicioSecion);
			pack();
			setVisible(true);
			
			bInicioSecion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
			
					if(DBManager.existeUsuarioLogin(txtUsuario.getText(),txtContraseña.getText())){
						
						JOptionPane.showMessageDialog(null, "Ha inciciado sesion correctamente","Inicio de sesion",JOptionPane.INFORMATION_MESSAGE);
						
						// Si inicia Sesion se guarda en usuario el usuario que ha iniciado sesion
						final Usuario user =(DBManager.obtenerUsuario(txtUsuario.getText(), txtContraseña.getText()));
						//AlquilarProductos alquilarProductos = new AlquilarProductos(user);
						//DevolverProductos devolverProductos = new DevolverProductos(user);
					  VentanaPrincipal.user = user;
					
						
						
						
						VentanaPrincipal.botonIniciarSesion.setEnabled(false);
						 setVisible(false);
						  System.out.println(String.format("%s",user.getNombreUsuario()));
						  
					
						
						
						
					
					}
					
					
				}
			});
			
	
		
}
 









         
	

}
