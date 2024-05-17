package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import db.DBManager;
import domain.Juego;
import domain.Libro;
import domain.Producto;

public class VentanaAñadirJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public VentanaAñadirJuego() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(375, 500);
		setTitle("AñadirJuego");
		 setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setVisible(true);
		setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
		
		JLabel AñadirLibro = new JLabel            ("Añadir Juego");
		AñadirLibro.setForeground(Color.WHITE);
		Font fuente = new Font("Arial",Font.BOLD,30);
        AñadirLibro.setFont(fuente);
		
		JLabel Titulo = new JLabel         ("            Titulo :           ");
		JLabel Precio = new JLabel       ("           Precio :          ");
		JLabel Compañia = new JLabel        ("       Compañia:          ");
		JLabel Plataforma = new JLabel     ("      Plataforma:           ");
		
		
		JTextField txtTitulo= new JTextField(14);
		JTextField txtPrecio= new JTextField(14);
		JTextField txtCompañia= new JTextField(14);
		JTextField txtPlataforma= new JTextField(14);
		
		
		
		
		JPanel central = new JPanel();
		
		JPanel pAñadirLibro = new JPanel();
		pAñadirLibro.setBackground(Color.darkGray);
	
		JPanel pTitulo= new JPanel();
		JPanel pPrecio = new JPanel();
		JPanel pCompañia = new JPanel();
		JPanel pPlataforma = new JPanel();
	
		JPanel pBoton = new JPanel();
		
		
		
		pAñadirLibro.setLayout(new FlowLayout());
		pAñadirLibro.add(AñadirLibro);
		
	
		
		pTitulo.setLayout(new FlowLayout());
		pTitulo.add(Titulo);
		pTitulo.add(txtTitulo);
		
		pPrecio.setLayout(new FlowLayout());
		pPrecio.add(Precio);
		pPrecio.add(txtPrecio);
		
		pCompañia.setLayout(new FlowLayout());
		pCompañia.add(Compañia);
		pCompañia.add(txtCompañia);
		
		pPlataforma.setLayout(new FlowLayout());
		pPlataforma.add(Plataforma);
		pPlataforma.add(txtPlataforma);
		

		JButton añadirJuego = new JButton("Añadir Juego");

		
		pBoton.setLayout(new FlowLayout());
		pBoton.add(añadirJuego);
		
		central.setLayout(new GridLayout(7, 1));
		
		central.add(pAñadirLibro);
	
		central.add(pTitulo);
		central.add(pPrecio);
		central.add(pCompañia);
		central.add(pPlataforma);
		central.add(pBoton);
		
		add(central);
		pack();
		añadirJuego.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Juego nuevoJuego = new Juego();
				    nuevoJuego.setTitulo(txtTitulo.getText());
				    nuevoJuego.setPrecio(Double.parseDouble(txtPrecio.getText()));
				    nuevoJuego.setCompania(txtCompañia.getText());
				    nuevoJuego.setPlataforma(txtPlataforma.getText());				  
				    
				    // Incrementar el contador de productos después de asignar el ID
				    int idJuego =  DBManager.devolverUltimoId() +1;
				    nuevoJuego.setId(idJuego);
				  
				    
				    // Insertar el libro en la base de datos
				    DBManager.insertarJuego(nuevoJuego);
				    txtTitulo.setText("");
				    txtPrecio.setText("");
				    txtCompañia.setText("");
				    txtPlataforma.setText("");
			}
		});
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new VentanaAñadirJuego();
					
				
				}
			});
					}

}
