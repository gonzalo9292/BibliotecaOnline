 package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.desktop.PrintFilesEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import db.DBManager;
import domain.Juego;
import domain.Libro;
import domain.Pelicula;
import domain.Producto;
import domain.Usuario;

public class AlquilarProductos extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario user;

	
	

    
    
	

	public AlquilarProductos(Usuario user) {
		
		   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setSize(700, 500);
	        setTitle("AlquilarProductos");
	        
	        setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	                (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
	        
	        setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));

	        this.user = user;
	        System.out.println(user.getListaProductos());
		
			JPanel panelPrincipal = new JPanel(new BorderLayout());
			add(panelPrincipal);
			JPanel panelNorte = new JPanel(new GridLayout(1,3));
			
			
			
			 JMenuBar menuBar = new JMenuBar();
			 menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
			JMenu menu = new JMenu("Filtrar");
			JMenu menu2 = new JMenu("Producto");
			JMenu menu3 = new JMenu("Precio");
			
			JMenuItem libros = new JMenuItem("Libros");
			JMenuItem juegos = new JMenuItem("Juegos");
			JMenuItem peliculas = new JMenuItem("Peliculas");
			
			JMenuItem masmenos = new JMenuItem("mas-menos");
			JMenuItem menosmas = new JMenuItem("menos-mas");
			
			menu.add(menu2);
			menu.add(menu3);
			
			menu2.add(libros);
			menu2.add(juegos);
			menu2.add(peliculas);
			
			menu3.add(masmenos);
			menu3.add(menosmas);
			
			 menuBar.add(menu);
			 menuBar.setBackground(Color.white);
		     setJMenuBar(menuBar);
		    
		     
			JLabel label = new JLabel("ALQUILAR PRODUCTOS");
		   	Font fuente = new Font("Arial",Font.BOLD,18);
	        label.setFont(fuente);
	        label.setLayout(new FlowLayout(FlowLayout.CENTER));
			JButton alquilar = new JButton("Alquilar");
			ImageIcon icono = new ImageIcon("resorces/images/iconos/carrito.png");
			alquilar.setIcon(icono);
			alquilar.setBackground(Color.white);
			
			
			
			panelPrincipal.add(panelNorte,BorderLayout.NORTH);
			panelNorte.add(menuBar);
			panelNorte.add(label);
			panelNorte.add(alquilar);
			
			
			DefaultTableModel modeloLibro = new DefaultTableModel();

		        // A�adir columnas al modelo de tabla
		     modeloLibro.addColumn("ID");
		     modeloLibro.addColumn("Nombre");
		     modeloLibro.addColumn("Precio");
		     modeloLibro.addColumn("Autor");
		     modeloLibro.addColumn("Numero de paginas");

		      // A�adir filas al modelo de tabla
        
		        // Crear tabla con el modelo de datos
		     JTable tablaLibro = new JTable(modeloLibro);

		        // Crear contenedor y a�adir la tabla
		     JScrollPane scrollPanelLibro = new JScrollPane(tablaLibro);
		     
		     
		     
		     
		     
		     
		     
		     DefaultTableModel modeloJuego = new DefaultTableModel();

		        // A�adir columnas al modelo de tabla
		     modeloJuego.addColumn("ID");
		     modeloJuego.addColumn("Nombre");
		     modeloJuego.addColumn("Precio");
		     modeloJuego.addColumn("Compa�ia");
		     modeloJuego.addColumn("Plataforma");

		      // A�adir filas al modelo de tabla
     
		        // Crear tabla con el modelo de datos
		     JTable tablaJuego = new JTable(modeloJuego);

		        // Crear contenedor y a�adir la tabla
		     JScrollPane scrollPanelJuego = new JScrollPane(tablaJuego);
		     
		     
		     
		     
		     
		     DefaultTableModel modeloPelicula = new DefaultTableModel();
		    

		        // A�adir columnas al modelo de tabla
		     modeloPelicula.addColumn("ID");
		     modeloPelicula.addColumn("Nombre");
		     modeloPelicula.addColumn("Precio");
		     modeloPelicula.addColumn("Director");
		     modeloPelicula.addColumn("Duracion");

		      // A�adir filas al modelo de tabla
  
		        // Crear tabla con el modelo de datos
		     JTable tablaPelicula = new JTable(modeloPelicula);
		     

		        // Crear contenedor y a�adir la tabla
		     JScrollPane scrollPanelPelicula = new JScrollPane(tablaPelicula);
		     
		       
		       
		        
		        //panelPrincipal.add(scrollPane,BorderLayout.CENTER);
		        
		   
		        
		        
		        libros.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						panelPrincipal.removeAll();
						panelPrincipal.add(panelNorte,BorderLayout.NORTH);
						// TODO Auto-generated method stub
						List<Libro> listaLibros = DBManager.obtenerLibrosBD();
					        // Actualiza la tabla con la nueva lista de libros.
					    actualizarTablaLibros(listaLibros,modeloLibro);
						panelPrincipal.add(scrollPanelLibro,BorderLayout.CENTER);
						panelPrincipal.revalidate();
				        panelPrincipal.repaint();
				        
				        masmenos.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								List<Libro> listaLibros2 = OrdenarLibrosDeMayoraMenor(listaLibros);
								 actualizarTablaLibros(listaLibros2,modeloLibro);
									panelPrincipal.add(scrollPanelLibro,BorderLayout.CENTER);
									panelPrincipal.revalidate();
							        panelPrincipal.repaint();
							}
						});
				        
				        menosmas.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								List<Libro> listaLibros2 = OrdenarLibrosDeMenoraMayor(listaLibros);                   
								 actualizarTablaLibros(listaLibros2,modeloLibro);
									panelPrincipal.add(scrollPanelLibro,BorderLayout.CENTER);
									panelPrincipal.revalidate();
							        panelPrincipal.repaint();
							}
						});
				        
				        alquilar.addActionListener(new ActionListener() {
				        	
				        		
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								int filaSeleccionada = tablaLibro.getSelectedRow();
								if(filaSeleccionada != -1) {
									Libro libro = new Libro();
									libro.setId((Integer) tablaLibro.getValueAt(filaSeleccionada,0));  
									libro.setTitulo((String) tablaLibro.getValueAt(filaSeleccionada,1));
									libro.setPrecio((double) tablaLibro.getValueAt(filaSeleccionada, 2));
									libro.setAutor((String) tablaLibro.getValueAt(filaSeleccionada, 3));
									libro.setNumPaginas((Integer) tablaLibro.getValueAt(filaSeleccionada, 4));
									user.setListaProducto(libro);
									
									for(Producto p2 : user.getListaProductos()) {
										System.out.println(String.format("%s,%s,%f",p2.getId(),p2.getTitulo(),p2.getPrecio()));
									}
									
								
									if(user!= null) {
								
										
										
										int idLibro = (Integer) tablaLibro.getValueAt(filaSeleccionada,0);
										DBManager.modificarAlquilerEnTablaLibro(idLibro);
										System.out.println(user.getNombreUsuario());
										DBManager.RegistrarAlquiler(user.getNombreUsuario(), libro,"libro");
										
									
										      
										
									}
									
								
								
									modeloLibro.removeRow(filaSeleccionada);
									panelPrincipal.revalidate();
									panelPrincipal.repaint();
									
								}else {
									
								}
								
							}
						});
				       
				       
				       
					}
				});
		        
		        juegos.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						panelPrincipal.removeAll();
						panelPrincipal.add(panelNorte,BorderLayout.NORTH);
						// TODO Auto-generated method stub
						List<Juego> listaJuegos = DBManager.obtenerJuegosBD();
					        // Actualiza la tabla con la nueva lista de libros.
					    actualizarTablaJuegos(listaJuegos,modeloJuego);
						panelPrincipal.add(scrollPanelJuego,BorderLayout.CENTER);
						panelPrincipal.revalidate();
				        panelPrincipal.repaint();
				        
				        masmenos.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								List<Juego> listaJuegos2 = OrdenarJuegosDeMayoraMenor(listaJuegos);
								 actualizarTablaJuegos(listaJuegos2,modeloJuego);
									panelPrincipal.add(scrollPanelJuego,BorderLayout.CENTER);
									panelPrincipal.revalidate();
							        panelPrincipal.repaint();
							}
						});
				        
				        menosmas.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								List<Juego> listaJuegos2 = OrdenarJuegosDeMenoraMayor(listaJuegos);                   
								 actualizarTablaJuegos(listaJuegos2,modeloJuego);
									panelPrincipal.add(scrollPanelJuego,BorderLayout.CENTER);
									panelPrincipal.revalidate();
							        panelPrincipal.repaint();
							}
						});
				        	alquilar.addActionListener(new ActionListener() {
				        	
				        		
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								int filaSeleccionada = tablaJuego.getSelectedRow();
								if(filaSeleccionada != -1) {
									Juego juego = new Juego();
									
									juego.setId((Integer) tablaJuego.getValueAt(filaSeleccionada,0));  
									juego.setTitulo((String) tablaJuego.getValueAt(filaSeleccionada,1));
									juego.setPrecio((double) tablaJuego.getValueAt(filaSeleccionada, 2));
									juego.setCompania((String) tablaJuego.getValueAt(filaSeleccionada, 3));
									juego.setPlataforma((String) tablaJuego.getValueAt(filaSeleccionada, 4));
									user.setListaProducto(juego);
									
									for(Producto p2 : user.getListaProductos()) {
										System.out.println(String.format("%s,%s,%f",p2.getId(),p2.getTitulo(),p2.getPrecio()));
									}
									
								
									if(user!= null) {
								
										
										
										int idJuego = (Integer) tablaJuego.getValueAt(filaSeleccionada,0);
										DBManager.modificarAlquilerEnTablaJuego(idJuego);
										System.out.println(user.getNombreUsuario());
										DBManager.RegistrarAlquiler(user.getNombreUsuario(), juego,"juego");
										
									
										      
										
									}
									
								
								
									modeloJuego.removeRow(filaSeleccionada);
									panelPrincipal.revalidate();
									panelPrincipal.repaint();
									
								}else {
									
								}
								
							}
						});
					}
				});
		        
		        
		        peliculas.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						panelPrincipal.removeAll();
						panelPrincipal.add(panelNorte,BorderLayout.NORTH);
						// TODO Auto-generated method stub
						List<Pelicula> listaPeliculas = DBManager.obtenerPeliculasBD();
					        // Actualiza la tabla con la nueva lista de libros.
					    actualizarTablaPeliculas(listaPeliculas,modeloPelicula);
						panelPrincipal.add(scrollPanelPelicula,BorderLayout.CENTER);
						panelPrincipal.revalidate();
				        panelPrincipal.repaint();
				        
				        masmenos.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								List<Pelicula> listaPeliculas2 = OrdenarPeliculasDeMayoraMenor(listaPeliculas);
								 actualizarTablaPeliculas(listaPeliculas2,modeloPelicula);
									panelPrincipal.add(scrollPanelPelicula,BorderLayout.CENTER);
									panelPrincipal.revalidate();
							        panelPrincipal.repaint();
							}
						});
				        
				        menosmas.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								List<Pelicula> listaPeliculas2 = OrdenarPeliculasDeMenoraMayor(listaPeliculas);                   
								 actualizarTablaPeliculas(listaPeliculas2,modeloPelicula);
									panelPrincipal.add(scrollPanelPelicula,BorderLayout.CENTER);
									panelPrincipal.revalidate();
							        panelPrincipal.repaint();
							}
						});
				        
				        alquilar.addActionListener(new ActionListener() {
				        	
				        		
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								int filaSeleccionada = tablaPelicula.getSelectedRow();
								if(filaSeleccionada != -1) {
									Pelicula pelicula = new Pelicula();
									pelicula.setId((Integer) tablaPelicula.getValueAt(filaSeleccionada,0));  
									pelicula.setTitulo((String) tablaPelicula.getValueAt(filaSeleccionada,1));
									pelicula.setPrecio((double) tablaPelicula.getValueAt(filaSeleccionada, 2));
									pelicula.setDirector((String) tablaPelicula.getValueAt(filaSeleccionada, 3));
									pelicula.setDuracion((Integer) tablaPelicula.getValueAt(filaSeleccionada, 4));
									user.setListaProducto(pelicula);
									
									for(Producto p2 : user.getListaProductos()) {
										System.out.println(String.format("%s,%s,%f",p2.getId(),p2.getTitulo(),p2.getPrecio()));
									}
									
								
									if(user!= null) {
								
										
										
										int idPelicula = (Integer) tablaPelicula.getValueAt(filaSeleccionada,0);
										DBManager.modificarAlquilerEnTablaPelicula(idPelicula);
										System.out.println(user.getNombreUsuario());
										DBManager.RegistrarAlquiler(user.getNombreUsuario(), pelicula,"pelicula");
										
									
										      
										
									}
									
								
								
									modeloPelicula.removeRow(filaSeleccionada);
									panelPrincipal.revalidate();
									panelPrincipal.repaint();
									
								}else {
									
								}
								
							}
						});
					}
				});
		        
		     
		        
		    
		        
		        
		        
		
		
			setVisible(true);
	}
	
	
	
    
    public void actualizarTablaLibros(List<Libro> lista,DefaultTableModel modeloLibro) {
      modeloLibro.setRowCount(0);
 
      	
      	 for(Libro l : lista) {
      	        modeloLibro.addRow(new Object[] {l.getId(), l.getTitulo(), l.getPrecio(), l.getAutor(),l.getNumPaginas()});
      	    }
      	
      }
    
    public void actualizarTablaJuegos(List<Juego> lista,DefaultTableModel modeloJuego) {
        modeloJuego.setRowCount(0);
     
        	
        	 for(Juego j : lista) {
        	        modeloJuego.addRow(new Object[] {j.getId(), j.getTitulo(), j.getPrecio(),j.getCompania() ,j.getPlataforma()});
        	    }
        	
        }
    public void actualizarTablaPeliculas(List<Pelicula> lista,DefaultTableModel modeloPelicula) {
        modeloPelicula.setRowCount(0);
       
        	
        	 for(Pelicula p : lista) {
        	        modeloPelicula.addRow(new Object[] {p.getId(), p.getTitulo(), p.getPrecio(), p.getDirector(),p.getDuracion()});
        	    }
        	
        	 
        	 
        }
    
   public static class comparadorLibro implements Comparator<Libro>{

	@Override
	public int compare(Libro o1, Libro o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.getPrecio(), o2.getPrecio());
	}
	   
   }
   public static class comparadorJuego implements Comparator<Juego>{

		@Override
		public int compare(Juego o1, Juego o2) {
			// TODO Auto-generated method stub
			return  Double.compare(o1.getPrecio(), o2.getPrecio());
	}
		   
   }
   public static class comparadorPelicula implements Comparator<Pelicula>{

		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			// TODO Auto-generated method stub
			return  Double.compare(o1.getPrecio(), o2.getPrecio());
	}
		   
   }
   
   
   public List<Libro> OrdenarLibrosDeMayoraMenor(List<Libro> lista) {

	   Collections.sort(lista,new comparadorLibro());
       Collections.reverse(lista);
	                
	   return lista;
	   
	   
   }
   public List<Libro> OrdenarLibrosDeMenoraMayor(List<Libro> lista) {
	   Collections.sort(lista,new comparadorLibro());
	   return lista;
	   
	   
   }
   public List<Juego> OrdenarJuegosDeMayoraMenor(List<Juego> lista) {
	 
	   Collections.sort(lista,new comparadorJuego());
	   Collections.reverse(lista);
	   return lista;
	   
	   
   }
   public List<Juego> OrdenarJuegosDeMenoraMayor(List<Juego> lista) {

	   Collections.sort(lista,new comparadorJuego());
	   return lista;
	   
	   
   }
   public List<Pelicula> OrdenarPeliculasDeMayoraMenor(List<Pelicula> lista) {
	 
	   Collections.sort(lista,new comparadorPelicula());
	   Collections.reverse(lista);
	   return lista;
	   
	   
   }
   public List<Pelicula> OrdenarPeliculasDeMenoraMayor(List<Pelicula> lista) {
	   Collections.sort(lista,new comparadorPelicula());
	   return lista;
	   
	   
   }
    
 
  
	






}
