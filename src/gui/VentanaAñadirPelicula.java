package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.DBManager;
import domain.Juego;
import domain.Pelicula;
import domain.Producto;

public class VentanaAñadirPelicula extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public VentanaAñadirPelicula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(375, 500);
		setTitle("AñadirLibro");
		 setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setVisible(true);
		setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
		
		JLabel AñadirPelicula = new JLabel            ("Añadir Pelicula");
		AñadirPelicula.setForeground(Color.WHITE);
		Font fuente = new Font("Arial",Font.BOLD,30);
        AñadirPelicula.setFont(fuente);
		
		JLabel Titulo = new JLabel         ("            Titulo :           ");
		JLabel Precio = new JLabel       ("           Precio :          ");
		JLabel Director = new JLabel        ("            Director:              ");
		JLabel Duracion = new JLabel     ("   Duracion:");
		
	
		JTextField txtTitulo= new JTextField(14);
		JTextField txtPrecio= new JTextField(14);
		JTextField txtDirector= new JTextField(14);
		JTextField txtDuracion= new JTextField(14);
		
		
		
		
		JPanel central = new JPanel();
		
		JPanel pAñadirPelicula = new JPanel();
		pAñadirPelicula.setBackground(Color.darkGray);
		
		JPanel pTitulo= new JPanel();
		JPanel pPrecio = new JPanel();
		JPanel pDirector = new JPanel();
		JPanel pDuracion = new JPanel();
	
		JPanel pBoton = new JPanel();
		
		
		
		pAñadirPelicula.setLayout(new FlowLayout());
		pAñadirPelicula.add(AñadirPelicula);
		
		
		
		pTitulo.setLayout(new FlowLayout());
		pTitulo.add(Titulo);
		pTitulo.add(txtTitulo);
		
		pPrecio.setLayout(new FlowLayout());
		pPrecio.add(Precio);
		pPrecio.add(txtPrecio);
		
		pDirector.setLayout(new FlowLayout());
		pDirector.add(Director);
		pDirector.add(txtDirector);
		
		pDuracion.setLayout(new FlowLayout());
		pDuracion.add(Duracion);
		pDuracion.add(txtDuracion);
		

		JButton añadirPelicula = new JButton("Añadir Pelicula");

		
		pBoton.setLayout(new FlowLayout());
		pBoton.add(añadirPelicula);
		
		central.setLayout(new GridLayout(7, 1));
		
		central.add(pAñadirPelicula);
		
		central.add(pTitulo);
		central.add(pPrecio);
		central.add(pDirector);
		central.add(pDuracion);
		central.add(pBoton);
		
		add(central);
		pack();
		añadirPelicula.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Pelicula nuevoPelicula = new Pelicula();
				    nuevoPelicula.setTitulo(txtTitulo.getText());
				    nuevoPelicula.setPrecio(Double.parseDouble(txtPrecio.getText()));
				    nuevoPelicula.setDirector(txtDirector.getText());
				    nuevoPelicula.setDuracion(Integer.parseInt(txtDuracion.getText()));
				    
				    int idPelicula =  DBManager.devolverUltimoId() +1;
				    nuevoPelicula.setId(idPelicula);
				    
				    
				    // Insertar el libro en la base de datos
				    DBManager.insertarPelicula(nuevoPelicula);
				    txtTitulo.setText("");
				    txtPrecio.setText("");
				    txtDirector.setText("");
				    txtDuracion.setText("");
			}
		});
		
		setVisible(true);
		
	
	}
	
	

}
