package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.RemoteStub;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

import db.DBManager;
import domain.Juego;
import domain.Libro;
import domain.Pelicula;
import domain.Producto;
import domain.Usuario;

public class DevolverProductos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario user;
	public static List<Usuario> listaUsuarios ;
	public static Map<String,List<Producto>> mapaProductosUsuarios= new HashMap<>();// Se rellena con la bd
	
	
public DevolverProductos(Usuario user) {
	
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
			JMenuItem productos= new JMenuItem("Productos");
			JMenuItem juegos = new JMenuItem("Juegos");
			JMenuItem peliculas = new JMenuItem("Peliculas");
			
			menu.add(productos);
			//menu.add(juegos);
			//menu.add(peliculas);
			
			 menuBar.add(menu);
			 menuBar.setBackground(Color.white);
		     setJMenuBar(menuBar);
		     
			JLabel label = new JLabel("DEVOLVER PRODUCTOS");
		   	Font fuente = new Font("Arial",Font.BOLD,18);
		    label.setFont(fuente);
		    label.setLayout(new FlowLayout(FlowLayout.CENTER));
			JButton devolver = new JButton("Devolver");
			ImageIcon icono = new ImageIcon("resorces/images/iconos/devolver.png");
			devolver.setIcon(icono);
			devolver.setBackground(Color.white);
			
			
			panelPrincipal.add(panelNorte,BorderLayout.NORTH);
			panelNorte.add(menuBar);
			panelNorte.add(label);
			panelNorte.add(devolver);
			DefaultTableModel modeloProducto = new DefaultTableModel();
		
		        // Añadir columnas al modelo de tabla
		        modeloProducto.addColumn("ID");
		        modeloProducto.addColumn("Nombre");
		        modeloProducto.addColumn("Precio");
		        modeloProducto.addColumn("Tipo");
		
		        // Añadir filas al modelo de tabla
		      
		
		        // Crear tabla con el modelo de datos
		        JTable tablaProducto = new JTable(modeloProducto);
		
		        // Crear contenedor y añadir la tabla
		        JScrollPane scrollPane = new JScrollPane(tablaProducto);
		       
		        
		        panelPrincipal.add(scrollPane,BorderLayout.CENTER);
		        
		        
		        
		        productos.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						panelPrincipal.removeAll();
						panelPrincipal.add(panelNorte,BorderLayout.NORTH);

						mapaProductosUsuarios = DBManager.datosDevoluciones();
					
						
						
						//System.out.println(mapaProductosUsuarios);
					        // Actualiza la tabla con la nueva lista de libros.
					    actualizarTablaProducto(mapaProductosUsuarios,user.getNombreUsuario(),modeloProducto);
						panelPrincipal.add(scrollPane,BorderLayout.CENTER);
						panelPrincipal.revalidate();
				        panelPrincipal.repaint();
				        
				        devolver.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								int filaSeleccionada = tablaProducto.getSelectedRow();
								if(filaSeleccionada!=-1) {
									Producto objLibro = new Libro();
									Producto objJuego = new Juego();
									Producto objPelicula = new Pelicula();
									
									if(tablaProducto.getValueAt(filaSeleccionada, 3).toString().toLowerCase().equals("libro") ) {
										int id = (Integer) tablaProducto.getValueAt(filaSeleccionada,0);
										System.out.println(id);
										objLibro = DBManager.obtenerLibroBD(id);
										DBManager.modificarAlquiler2EnTablaLibro(id);
										DBManager.eliminarAlquiler(id);
									}else if (tablaProducto.getValueAt(filaSeleccionada, 3).toString().toLowerCase().equals("juego") ) {
										int id = (Integer) tablaProducto.getValueAt(filaSeleccionada,0);
										objJuego = DBManager.obtenerJuegoBD(id);
										DBManager.modificarAlquiler2EnTablaJuego(id);
										DBManager.eliminarAlquiler(id);
									}else if(tablaProducto.getValueAt(filaSeleccionada, 3).toString().toLowerCase().equals("pelicula")) {
										int id = (Integer) tablaProducto.getValueAt(filaSeleccionada,0);
										objPelicula = DBManager.obtenerPeliculaBD(id);
										DBManager.modificarAlquiler2EnTablaPelicula(id);
										DBManager.eliminarAlquiler(id);
									}
										
									
									modeloProducto.removeRow(filaSeleccionada);
									panelPrincipal.revalidate();
									panelPrincipal.repaint();
									
								/*	for(List<Producto> productos : mapaProductos.values()) {
										for(Producto product : productos) {
											if(product.getId() == p.getId()) {
												System.out.println(product +"()()"+p);
												if(product instanceof Libro) {
													Libro libro = DBManager.obtenerLibroCopiaBD(p.getId());
													System.out.println(libro.getId());
													DBManager.insertarLibro(libro);
												}else if (product instanceof Juego) {
													Juego juego = DBManager.obtenerJuegoCopiaBD(p.getId());
													System.out.println(juego.getId());
													DBManager.insertarJuego(juego);
												}else if(product instanceof Pelicula) {
													Pelicula pelicula = DBManager.obtenerPeliculaCopiaBD(p.getId());
													System.out.println(pelicula.getId());
													DBManager.insertarPelicula(pelicula);
												}else{
													System.out.println("P es nulo");
												}
											}
										}
									}*/	
									
									
								}
							}
						});
					}
			
					
					
					
				});
		        
		        
		
		
			setVisible(true);
			
			
			
		}




public void actualizarTablaProducto(Map<String,List<Producto>> mapa, String nombre_usuario ,DefaultTableModel modeloProducto) {
    modeloProducto.setRowCount(0);
   
    	
    		 List<Producto> listaProductosUsuario = mapa.get(nombre_usuario);
    		 for(Producto p:listaProductosUsuario) {
    			 modeloProducto.addRow(new Object[] {p.getId(), p.getTitulo(), p.getPrecio(), DBManager.obtenerTipoBD(p.getId()) });
    		 }
    	
    	 
    	
    	
    }

       

       
	
}
	


