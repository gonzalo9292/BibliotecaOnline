package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class DevolverProductos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
public DevolverProductos() {
	
			 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		     setSize(700, 500);
		     setTitle("DevoolverProductos");
		      
		     setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
		             (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
			  
		    setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
		
			JPanel panelPrincipal = new JPanel(new BorderLayout());
			add(panelPrincipal);
			JPanel panelNorte = new JPanel(new GridLayout(1,3));
			
			
			 JMenuBar menuBar = new JMenuBar();
			 menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
			JMenu menu = new JMenu("Productos a tu disposicion:");
			JMenuItem libros = new JMenuItem("Libros");
			JMenuItem juegos = new JMenuItem("Juegos");
			JMenuItem peliculas = new JMenuItem("Peliculas");
			
			menu.add(libros);
			menu.add(juegos);
			menu.add(peliculas);
			
			 menuBar.add(menu);
			 menuBar.setBackground(Color.white);
		     setJMenuBar(menuBar);
		     
			JLabel label = new JLabel("DEVOLVER PRODUCTOS");
		   	Font fuente = new Font("Arial",Font.BOLD,18);
		    label.setFont(fuente);
		    label.setLayout(new FlowLayout(FlowLayout.CENTER));
			JButton alquilar = new JButton("Devolver");
			ImageIcon icono = new ImageIcon("resorces/images/iconos/devolver.png");
			alquilar.setIcon(icono);
			alquilar.setBackground(Color.white);
			
			
			panelPrincipal.add(panelNorte,BorderLayout.NORTH);
			panelNorte.add(menuBar);
			panelNorte.add(label);
			panelNorte.add(alquilar);
			DefaultTableModel modeloTabla = new DefaultTableModel();
		
		        // A�adir columnas al modelo de tabla
		        modeloTabla.addColumn("ID");
		        modeloTabla.addColumn("Nombre");
		        modeloTabla.addColumn("Precio");
		
		        // A�adir filas al modelo de tabla
		        modeloTabla.addRow(new Object[]{1, "Libro", 20.0});
		        modeloTabla.addRow(new Object[]{2, "Pel�cula", 15.5});
		        modeloTabla.addRow(new Object[]{3, "Juego", 30.75});
		        modeloTabla.addRow(new Object[]{1, "Libro", 20.0});
		        modeloTabla.addRow(new Object[]{2, "Pel�cula", 15.5});
		        modeloTabla.addRow(new Object[]{3, "Juego", 30.75});
		        modeloTabla.addRow(new Object[]{1, "Libro", 20.0});
		        modeloTabla.addRow(new Object[]{2, "Pel�cula", 15.5});
		        modeloTabla.addRow(new Object[]{3, "Juego", 30.75});
		        modeloTabla.addRow(new Object[]{1, "Libro", 20.0});
		        modeloTabla.addRow(new Object[]{2, "Pel�cula", 15.5});
		        modeloTabla.addRow(new Object[]{3, "Juego", 30.75});
		        modeloTabla.addRow(new Object[]{1, "Libro", 20.0});
		        modeloTabla.addRow(new Object[]{2, "Pel�cula", 15.5});
		        modeloTabla.addRow(new Object[]{3, "Juego", 30.75});
		        modeloTabla.addRow(new Object[]{1, "Libro", 20.0});
		        modeloTabla.addRow(new Object[]{2, "Pel�cula", 15.5});
		        modeloTabla.addRow(new Object[]{3, "Juego", 30.75});
		        modeloTabla.addRow(new Object[]{1, "Libro", 20.0});
		        modeloTabla.addRow(new Object[]{2, "Pel�cula", 15.5});
		        modeloTabla.addRow(new Object[]{3, "Juego", 30.75});
		        modeloTabla.addRow(new Object[]{1, "Libro", 20.0});
		        modeloTabla.addRow(new Object[]{2, "Pel�cula", 15.5});
		        modeloTabla.addRow(new Object[]{3, "Juego", 30.75});
		        modeloTabla.addRow(new Object[]{1, "Libro", 20.0});
		        modeloTabla.addRow(new Object[]{2, "Pel�cula", 15.5});
		        modeloTabla.addRow(new Object[]{3, "Juego", 30.75});
		
		        // Crear tabla con el modelo de datos
		        JTable tabla = new JTable(modeloTabla);
		
		        // Crear contenedor y a�adir la tabla
		        JScrollPane scrollPane = new JScrollPane(tabla);
		       
		        
		        panelPrincipal.add(scrollPane,BorderLayout.CENTER);
		
		
			setVisible(true);
		}
		
		public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new DevolverProductos();
				
			}
		});
		}

       
       
       
	
}
	


