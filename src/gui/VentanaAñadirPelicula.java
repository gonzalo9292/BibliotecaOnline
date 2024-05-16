package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaA�adirPelicula extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public VentanaA�adirPelicula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(375, 500);
		setTitle("A�adirLibro");
		 setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setVisible(true);
		setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
		
		JLabel A�adirPelicula = new JLabel            ("A�adir Pelicula");
		A�adirPelicula.setForeground(Color.WHITE);
		Font fuente = new Font("Arial",Font.BOLD,30);
        A�adirPelicula.setFont(fuente);
		JLabel Id = new JLabel            ("               Id :              ");
		JLabel Titulo = new JLabel         ("            Titulo :           ");
		JLabel Precio = new JLabel       ("           Precio :          ");
		JLabel Director = new JLabel        ("            Director:              ");
		JLabel Duracion = new JLabel     ("   Duracion:");
		
		JTextField txtId = new JTextField(14);
		JTextField txtTitulo= new JTextField(14);
		JTextField txtPrecio= new JTextField(14);
		JTextField txtDirector= new JTextField(14);
		JTextField txtDuracion= new JTextField(14);
		
		
		
		
		JPanel central = new JPanel();
		
		JPanel pA�adirPelicula = new JPanel();
		pA�adirPelicula.setBackground(Color.darkGray);
		JPanel pId = new JPanel();
		JPanel pTitulo= new JPanel();
		JPanel pPrecio = new JPanel();
		JPanel pDirector = new JPanel();
		JPanel pDuracion = new JPanel();
	
		JPanel pBoton = new JPanel();
		
		
		
		pA�adirPelicula.setLayout(new FlowLayout());
		pA�adirPelicula.add(A�adirPelicula);
		
		pId.setLayout(new FlowLayout());
		pId.add(Id);
		pId.add(txtId);
		
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
		

		JButton a�adirLibro = new JButton("A�adir Libro");

		
		pBoton.setLayout(new FlowLayout());
		pBoton.add(a�adirLibro);
		
		central.setLayout(new GridLayout(7, 1));
		
		central.add(pA�adirPelicula);
		central.add(pId);
		central.add(pTitulo);
		central.add(pPrecio);
		central.add(pDirector);
		central.add(pDuracion);
		central.add(pBoton);
		
		add(central);
		pack();
		
		setVisible(true);
		
	
	}
	
	

}
