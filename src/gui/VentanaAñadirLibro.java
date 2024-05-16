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
import javax.swing.SwingUtilities;

import db.DBManager;
import domain.Libro;
import domain.Producto;

public class VentanaA�adirLibro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VentanaA�adirLibro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(375, 500);
		setTitle("A�adirLibro");
		 setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		setVisible(true);
		setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
		
		JLabel A�adirLibro = new JLabel            ("A�adirLibro");
		A�adirLibro.setForeground(Color.WHITE);
		Font fuente = new Font("Arial",Font.BOLD,30);
        A�adirLibro.setFont(fuente);
		//JLabel Id = new JLabel            ("               Id :              ");
		JLabel Titulo = new JLabel         ("            Titulo :           ");
		JLabel Precio = new JLabel       ("           Precio :          ");
		JLabel Autor = new JLabel        ("            Autor:              ");
		JLabel NumeroDePaginas = new JLabel     ("   Numero de paginas:");
		
	//	JTextField txtId = new JTextField(14);
		JTextField txtTitulo= new JTextField(14);
		JTextField txtPrecio= new JTextField(14);
		JTextField txtAutor= new JTextField(14);
		JTextField txtNumeroDePaginas= new JTextField(14);
		
		
		
		
		JPanel central = new JPanel();
		
		JPanel pA�adirLibro = new JPanel();
		pA�adirLibro.setBackground(Color.darkGray);
	//	JPanel pId = new JPanel();
		JPanel pTitulo= new JPanel();
		JPanel pPrecio = new JPanel();
		JPanel pAutor = new JPanel();
		JPanel pNumeroDePaginas = new JPanel();
	
		JPanel pBoton = new JPanel();
		
		
		
		pA�adirLibro.setLayout(new FlowLayout());
		pA�adirLibro.add(A�adirLibro);
		
	//	pId.setLayout(new FlowLayout());
	//  pId.add(Id);
	//	pId.add(txtId);
		
		pTitulo.setLayout(new FlowLayout());
		pTitulo.add(Titulo);
		pTitulo.add(txtTitulo);
		
		pPrecio.setLayout(new FlowLayout());
		pPrecio.add(Precio);
		pPrecio.add(txtPrecio);
		
		pAutor.setLayout(new FlowLayout());
		pAutor.add(Autor);
		pAutor.add(txtAutor);
		
		pNumeroDePaginas.setLayout(new FlowLayout());
		pNumeroDePaginas.add(NumeroDePaginas);
		pNumeroDePaginas.add(txtNumeroDePaginas);
		

		JButton a�adirLibro = new JButton("A�adir Libro");

		
		pBoton.setLayout(new FlowLayout());
		pBoton.add(a�adirLibro);
		
		central.setLayout(new GridLayout(7, 1));
		
		central.add(pA�adirLibro);
	//	central.add(pId);
		central.add(pTitulo);
		central.add(pPrecio);
		central.add(pAutor);
		central.add(pNumeroDePaginas);
		central.add(pBoton);
		
		add(central);
		pack();
		
		a�adirLibro.addActionListener(new ActionListener() {
			
			@Override
		
			public void actionPerformed(ActionEvent e) {
			    // Crear un nuevo libro sin asignar manualmente el ID
			    Libro nuevoLibro = new Libro();
			    nuevoLibro.setTitulo(txtTitulo.getText());
			    nuevoLibro.setPrecio(Double.parseDouble(txtPrecio.getText()));
			    nuevoLibro.setAutor(txtAutor.getText());
			    
			    // Obtener el n�mero de p�ginas despu�s de asignar el ID
			    nuevoLibro.setId(Producto.getContadorProducto()); // Asignar el ID autom�ticamente
			    nuevoLibro.setNumPaginas(Integer.parseInt(txtNumeroDePaginas.getText()));
			    
			    // Incrementar el contador de productos despu�s de asignar el ID
			    Producto.setContadorProducto(Producto.getContadorProducto() + 1);
			    
			    // Insertar el libro en la base de datos
			    DBManager.insertarLibro(nuevoLibro);
			}

		});
		
		setVisible(true);
		
	
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new VentanaA�adirLibro();
					
				
				}
			});
					}

}
