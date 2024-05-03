package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import domain.Producto;
import domain.Usuario;



public class VentanaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton botonIniciarSesion = new JButton("IniciarSesion");
	public  Map<String,List<Producto>> mapaProductosUsuarios = new HashMap<>();
	public Usuario usuario = new Usuario();
	
	
	 public VentanaPrincipal() {
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setSize(700, 500);
	        setTitle("BibliotecaOnline");
	        
	        setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
	        
	        setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
	        
	     

	        JPanel panelInicial = new JPanel(new BorderLayout());
	        panelInicial.setBackground(new Color(173, 216, 230));
	        

	      
	 
	        JPanel panelNorte = new JPanel();
	        panelNorte.setBackground(Color.darkGray);
	      
	        JPanel panelCentral = new JPanel();
	       
	        
	        JLabel labelFoto = new JLabel();
	        labelFoto.setIcon(new ImageIcon("resorces/images/iconos/biblioteca2 (1).png"));
	        panelCentral.add(labelFoto);
	      
	    
	        JPanel panelSur = new JPanel();
	        panelSur.setBackground(Color.DARK_GRAY);
	       
	      
	      
	        
	        
	        
	        JButton botonAyuda = new JButton(new ImageIcon("resorces/images/iconos/icono2.png"));
	        botonAyuda.setPreferredSize(new Dimension (26,26));
			botonAyuda.setLayout(new FlowLayout(FlowLayout.LEFT));
	       

	        JButton botonAlquilar = new JButton("Alquilar Productos");
	        botonAlquilar.setPreferredSize(new Dimension(200,30));
	        JButton botonDevolver = new JButton("Devolver Productos");
	        botonDevolver.setPreferredSize(new Dimension(200,30));
	       
			botonIniciarSesion.setLayout(new FlowLayout(FlowLayout.RIGHT));
			botonIniciarSesion.setIcon(new ImageIcon("resorces/images/iconos/usuario.png"));
		    botonIniciarSesion.setPreferredSize(new Dimension(150,25));
	        JButton botonRegistrarse = new JButton("Registrarse");
			botonRegistrarse.setLayout(new FlowLayout(FlowLayout.RIGHT));
			botonRegistrarse.setPreferredSize(new Dimension(150,25));
			botonRegistrarse.setIcon(new ImageIcon("resorces/images/iconos/registrarse.png"));
			
			JButton botonPerfil = new JButton("Perfil");
			botonRegistrarse.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
	        JLabel titulo = new JLabel("TODOTECA");
	        titulo.setForeground(Color.WHITE);            
	    	Font fuente = new Font("Arial",Font.BOLD,30);
	        titulo.setFont(fuente);
			titulo.setLayout(new FlowLayout(FlowLayout.CENTER));
	        

	        add(panelInicial);
	        panelInicial.add(panelNorte,BorderLayout.NORTH);
	        panelInicial.add(panelCentral,BorderLayout.CENTER);
	        panelInicial.add(panelSur,BorderLayout.SOUTH);
	       
	        
	        panelNorte.add(botonIniciarSesion); 
	        panelNorte.add(botonAyuda);
	        panelNorte.add(titulo);
	        panelNorte.add(botonRegistrarse);
	     
	        
	  
	       
	      
	    
	        panelSur.add(botonAlquilar);
	        panelSur.add(botonDevolver);
	       



	        setVisible(true);
	        
	        
	        
	        
	        botonIniciarSesion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new VentanaIniciarSesion();
					
				}
			});
	        
	        
	        botonRegistrarse.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new VentanaRegistrarse();
				}
			});
	        
	        botonAyuda.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
						 StringBuilder texto = new StringBuilder();
					     try (BufferedReader br = new BufferedReader(new FileReader("resorces/data/Todoteca.txt"))) {
					           String linea;
					           while ((linea = br.readLine()) != null) {
					            texto.append(linea).append("\n");
					            }
					            
					            JTextArea area = new JTextArea(texto.toString());
								area.setEditable(false);
								area.setLineWrap(true);
								area.setWrapStyleWord(true);
								//Meter un scroll para que el texto no tenga problemas de visualizacion
								JScrollPane scroll = new JScrollPane(area);
								scroll.setPreferredSize(new Dimension(500,400));
								JOptionPane.showMessageDialog(null, scroll, "Quienes somos", JOptionPane.INFORMATION_MESSAGE);
								
					}catch(IOException ex) {
						ex.getStackTrace();
					}
					
				
					
					
				}
			});
	        
	        botonAlquilar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(botonIniciarSesion.isEnabled()) {
						JOptionPane.showMessageDialog(null, "Debes iniciar Sesion Antes", "Atencion!", JOptionPane.WARNING_MESSAGE);
					}else {
						new AlquilarProductos();
					}
					
				}
			});
	        
			botonDevolver.addActionListener(new ActionListener() {
									
			     	@Override
					public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new DevolverProductos();
				}
				});
	    }
	 
	
	 
	 public void mostrarDescripcion () {
		 
	 }
	 
	 public void agregarProductosAMapa( Map<String,List<Producto>> mapaUsuarioProductos,Producto p,String nombre_usuario) {
		 
		 mapaUsuarioProductos.putIfAbsent(nombre_usuario, new ArrayList<>());
		 mapaUsuarioProductos.get(nombre_usuario).add(p);
	 }

	
	
	
	
	public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaPrincipal();
				
				
			}
		});
	}

	
	
	
	

}
