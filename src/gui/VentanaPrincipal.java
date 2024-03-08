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



public class VentanaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public VentanaPrincipal() {
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setSize(700, 500);
	        setTitle("BibliotecaOnline");
	        
	        setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
	        
	        setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
	        
	     

	        JPanel panelInicial = new JPanel(new GridLayout(3,1));
	        panelInicial.setBackground(new Color(173, 216, 230));
	        

	      
	 
	        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.CENTER));
	      
	        JPanel panelCentral = new JPanel();
	      
	    
	        JPanel panelSur = new JPanel();
	       
	      
	      
	        JPanel panelBotones = new JPanel(new GridLayout(1,2));
	        JPanel panelBotones2 = new JPanel(new GridLayout(1,2));
	        
	        
	        JButton botonAyuda = new JButton(new ImageIcon("resorces/images/iconos/icono2.png"));
	        botonAyuda.setPreferredSize(new Dimension (27,27));
	       

	        JButton botonAlquilar = new JButton("Alquilar Productos");
	        JButton botonDevolver = new JButton("Devolver Productos");
	        JButton botonIniciarSesion = new JButton("IniciarSesion");
	        JButton botonRegistrarse = new JButton("Registrarse");
	        
	        JLabel titulo = new JLabel("TODOTECA");
	    	Font fuente = new Font("Arial",Font.BOLD,30);
	        titulo.setFont(fuente);
	        

	        add(panelInicial);
	        panelInicial.add(panelNorte);
	        panelInicial.add(panelCentral);
	        panelInicial.add(panelSur);
	       
	        
	        
	        panelNorte.add(botonAyuda);
	        panelNorte.add(titulo);
	     
	        
	        panelCentral.add(panelBotones);
	        panelSur.add(panelBotones2);
	      
	        panelBotones.add(botonIniciarSesion);
	        panelBotones.add(botonRegistrarse);
	        panelBotones2.add(botonAlquilar);
	        panelBotones2.add(botonDevolver);
	        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));
	        panelBotones2.setLayout(new FlowLayout(FlowLayout.CENTER,20,0));



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
					new AlquilarProductos();
				}
			});
	    }
	 
	
	 
	 public void mostrarDescripcion () {
		 
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
