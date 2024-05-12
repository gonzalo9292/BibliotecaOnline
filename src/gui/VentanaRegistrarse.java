 package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import db.DBManager;
import domain.Usuario;



public class VentanaRegistrarse extends JFrame{


	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> listaUsuarios = new ArrayList<>();
	
	

	//Color del panel
	
	public VentanaRegistrarse() {
		
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(375, 500);
			setTitle("Sing Up");
			 setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
		                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
			setVisible(true);
			setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
			
			JLabel Registrarse = new JLabel            ("Registrarse");
			Registrarse.setForeground(Color.WHITE);
			Font fuente = new Font("Arial",Font.BOLD,30);
	        Registrarse.setFont(fuente);
			JLabel DNI = new JLabel            ("               DNI :            ");
			JLabel Nombre = new JLabel         ("            Nombre :        ");
			JLabel Apellido = new JLabel       ("           Apellidos :       ");
			JLabel FechaNacimiento = new JLabel("Fecha de Nacimiento:");
			JLabel Usuario = new JLabel        ("Nombre de Usuario:  ");
			JLabel Contraseña = new JLabel     ("        Contraseña:         ");
			
			JTextField txtDNI = new JTextField(14);
			JTextField txtNombre= new JTextField(14);
			JTextField txtApellido= new JTextField(14);
			JTextField txtUsuario= new JTextField(14);
			JTextField txtContraseña= new JTextField(14);
			JTextField txtFecha= new JTextField(14);
			
			JButton btnRegistro = new JButton("Registrarse");
			JButton PoliticaDePrivacidad = new JButton("--Politica de privacidad--");
				PoliticaDePrivacidad.setForeground(Color.BLUE);
				PoliticaDePrivacidad.setBackground(Color.WHITE);
				
		
			JCheckBox pol = new JCheckBox("He leido y acepto los terminos de la politica de privacidad");
				pol.setSelected(false);
				pol.setEnabled(true);
				
			JPanel central = new JPanel();
			
			JPanel pRegistrarse = new JPanel();
			pRegistrarse.setBackground(Color.darkGray);
			JPanel pNombre = new JPanel();
			JPanel pApellido = new JPanel();
			JPanel pDNI = new JPanel();
			JPanel pFecha = new JPanel();
			JPanel pNombreU = new JPanel();
			JPanel pContraseña = new JPanel();
			JPanel pAvisos = new JPanel();
			JPanel pPrivacidad = new JPanel();
			JPanel pBoton = new JPanel();
			
			
		
		
			pRegistrarse.setLayout(new FlowLayout());
			pRegistrarse.add(Registrarse);
			
			pDNI.setLayout(new FlowLayout());
			pDNI.add(DNI);
			pDNI.add(txtDNI);
			
			pNombre.setLayout(new FlowLayout());
			pNombre.add(Nombre);
			pNombre.add(txtNombre);
			
			pApellido.setLayout(new FlowLayout());
			pApellido.add(Apellido);
			pApellido.add(txtApellido);
			
			pFecha.setLayout(new FlowLayout());
			pFecha.add(FechaNacimiento);
			pFecha.add(txtFecha);
			
			pNombreU.setLayout(new FlowLayout());
			pNombreU.add(Usuario);
			pNombreU.add(txtUsuario);
			
			pContraseña.setLayout(new FlowLayout());
			pContraseña.add(Contraseña);
			pContraseña.add(txtContraseña);
			
			pAvisos.setLayout(new FlowLayout());
		
			pAvisos.add(pol);
			
			pPrivacidad.setLayout(new FlowLayout());
			pPrivacidad.add(PoliticaDePrivacidad);
			
			pBoton.setLayout(new FlowLayout());
			pBoton.add(btnRegistro);
			
			central.setLayout(new GridLayout(12, 1));
			
			central.add(pRegistrarse);
			central.add(pDNI);
			central.add(pNombre);
			central.add(pApellido);
			central.add(pFecha);
			central.add(pNombreU);
			central.add(pContraseña);
			central.add(pAvisos);
			central.add(pPrivacidad);
			central.add(pBoton);
			
			add(central);
			
			
								
			btnRegistro.setEnabled(true);
			String fecha= "yyyy-MM-dd";
			txtFecha.setText(fecha);
			
	pack();
			
			
			
			PoliticaDePrivacidad.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					 StringBuilder texto = new StringBuilder();
				     try (BufferedReader br = new BufferedReader(new FileReader("resorces/data/Politica De privacidad.txt"))) {
				           String linea;
				           while ((linea = br.readLine()) != null) {
				            texto.append(linea).append("\n");
				            }
				            
				            JTextArea textarea = new JTextArea(texto.toString());
							textarea.setEditable(false);
							textarea.setLineWrap(true);
							textarea.setWrapStyleWord(true);
							JScrollPane scroll = new JScrollPane(textarea);
							scroll.setPreferredSize(new Dimension(500,400));
							JOptionPane.showMessageDialog(null, scroll, "Politica de privacidad", JOptionPane.INFORMATION_MESSAGE);
							
				}catch(IOException ex) {
					ex.getStackTrace();
				}
				
				}
			});
			
			
			
			btnRegistro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(!pol.isSelected()) {
						JOptionPane.showMessageDialog(null, "Debes aceptar los terminos antes de registrarte", "Cuidado!", JOptionPane.WARNING_MESSAGE);
					}else if(DBManager.existeUsuarioLogin(txtUsuario.getText(), txtContraseña.getText())) {
						JOptionPane.showMessageDialog(null, "Este usuario ya esta registrado", "Cuidado!", JOptionPane.WARNING_MESSAGE);
					}else {
						Usuario u = new Usuario(txtDNI.getText(),txtNombre.getText(),txtApellido.getText(),txtUsuario.getText(),txtContraseña.getText());
						listaUsuarios.add(u);
						DBManager.insertarUsuario(u);
						JOptionPane.showMessageDialog(null, "Tu registro se ha realizado correctamente", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
					}
					
				
				}
			});
	

}
	
	

	
	
	}
