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

public class VentanaA�adirJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public VentanaA�adirJuego() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(375, 500);
		setTitle("A�adirJuego");
		 setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setVisible(true);
		setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
		
		JLabel A�adirLibro = new JLabel            ("A�adir Juego");
		A�adirLibro.setForeground(Color.WHITE);
		Font fuente = new Font("Arial",Font.BOLD,30);
        A�adirLibro.setFont(fuente);
		
		JLabel Titulo = new JLabel         ("            Titulo :           ");
		JLabel Precio = new JLabel       ("           Precio :          ");
		JLabel Compa�ia = new JLabel        ("       Compa�ia:          ");
		JLabel Plataforma = new JLabel     ("      Plataforma:           ");
		
		
		JTextField txtTitulo= new JTextField(14);
		JTextField txtPrecio= new JTextField(14);
		JTextField txtCompa�ia= new JTextField(14);
		JTextField txtPlataforma= new JTextField(14);
		
		
		
		
		JPanel central = new JPanel();
		
		JPanel pA�adirLibro = new JPanel();
		pA�adirLibro.setBackground(Color.darkGray);
	
		JPanel pTitulo= new JPanel();
		JPanel pPrecio = new JPanel();
		JPanel pCompa�ia = new JPanel();
		JPanel pPlataforma = new JPanel();
	
		JPanel pBoton = new JPanel();
		
		
		
		pA�adirLibro.setLayout(new FlowLayout());
		pA�adirLibro.add(A�adirLibro);
		
	
		
		pTitulo.setLayout(new FlowLayout());
		pTitulo.add(Titulo);
		pTitulo.add(txtTitulo);
		
		pPrecio.setLayout(new FlowLayout());
		pPrecio.add(Precio);
		pPrecio.add(txtPrecio);
		
		pCompa�ia.setLayout(new FlowLayout());
		pCompa�ia.add(Compa�ia);
		pCompa�ia.add(txtCompa�ia);
		
		pPlataforma.setLayout(new FlowLayout());
		pPlataforma.add(Plataforma);
		pPlataforma.add(txtPlataforma);
		

		JButton a�adirJuego = new JButton("A�adir Juego");

		
		pBoton.setLayout(new FlowLayout());
		pBoton.add(a�adirJuego);
		
		central.setLayout(new GridLayout(7, 1));
		
		central.add(pA�adirLibro);
	
		central.add(pTitulo);
		central.add(pPrecio);
		central.add(pCompa�ia);
		central.add(pPlataforma);
		central.add(pBoton);
		
		add(central);
		pack();
		a�adirJuego.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Juego nuevoJuego = new Juego();
				    nuevoJuego.setTitulo(txtTitulo.getText());
				    nuevoJuego.setPrecio(Double.parseDouble(txtPrecio.getText()));
				    nuevoJuego.setCompania(txtCompa�ia.getText());
				    nuevoJuego.setPlataforma(txtPlataforma.getText());				  
				    
				    // Incrementar el contador de productos despu�s de asignar el ID
				    int idJuego =  DBManager.devolverUltimoId() +1;
				    nuevoJuego.setId(idJuego);
				  
				    
				    // Insertar el libro en la base de datos
				    DBManager.insertarJuego(nuevoJuego);
				    txtTitulo.setText("");
				    txtPrecio.setText("");
				    txtCompa�ia.setText("");
				    txtPlataforma.setText("");
			}
		});
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new VentanaA�adirJuego();
					
				
				}
			});
					}

}
