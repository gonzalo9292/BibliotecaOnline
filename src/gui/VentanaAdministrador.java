package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import db.DBManager;
import domain.Pelicula;
import domain.Producto;
import domain.Usuario;
import main.main;

public class VentanaAdministrador extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public VentanaAdministrador() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(700, 500);
			setTitle("BibliotecaOnline");
		
		    setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
		            (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
			
		    setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
		    

			JPanel panelPrincipal = new JPanel(new BorderLayout());
			add(panelPrincipal);
			
			JPanel panelNorte = new JPanel(new GridLayout(1,3));
			panelPrincipal.add(panelNorte,BorderLayout.NORTH);
			
			
			JPanel panelCentral = new JPanel();
			panelPrincipal.add(panelCentral,BorderLayout.CENTER);
			
			JPanel panelSur= new JPanel();
			panelPrincipal.add(panelSur,BorderLayout.SOUTH);
			
			JButton MostrarUsuarios = new JButton("Mostrar Usuarios");
			JLabel tituloLabel = new JLabel("        Administrador");
			
			JButton VerProducto = new JButton("Ver Productos");
			JButton EliminarUsuario = new JButton("Eliminar Usuario");
			JButton HacerInforme = new JButton("Hacer Informe");
			JButton AñadirProducto= new JButton("AñadirProducto");
			panelSur.add(EliminarUsuario);
			panelSur.add(HacerInforme);
			panelSur.add(AñadirProducto);
			
			        
			
			Font fuente = new Font("Arial",Font.BOLD,20);
	        tituloLabel.setFont(fuente);
			//tituloLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			panelNorte.add(MostrarUsuarios);
			panelNorte.add(tituloLabel);
			panelNorte.add(VerProducto);
			
			
			DefaultTableModel modeloUsuario = new DefaultTableModel();
			
	        // Añadir columnas al modelo de tabla
	        modeloUsuario.addColumn("Dni");
	        modeloUsuario.addColumn("Nombre");
	        modeloUsuario.addColumn("Apellidos");
	        modeloUsuario.addColumn("Nombre de usuario");
	        modeloUsuario.addColumn("Contraseña");
	
	        // Añadir filas al modelo de tabla
	      
	
	        // Crear tabla con el modelo de datos
	        JTable tablaUsuario = new JTable(modeloUsuario);
	
	        // Crear contenedor y añadir la tabla
	        JScrollPane scrollPane = new JScrollPane(tablaUsuario);
	        panelCentral.add(scrollPane);
	        
	        MostrarUsuarios.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	           
	                panelCentral.removeAll();
	                
	               
	                
	                
	                panelCentral.add(scrollPane);

	               
	                actualizarTablaUsuario(DBManager.obtenerTodosLosUsuarios(), modeloUsuario);
	                
	               
	                panelCentral.revalidate();
	                panelCentral.repaint();
	            }
	        });

	        // Acción para ver productos de un usuario seleccionado
	        VerProducto.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (tablaUsuario.getSelectedRow() >= 0) {
	                    // Obtener productos del usuario seleccionado
	                    Map<String, List<Producto>> mapaProductosUsuario = DBManager.datosDevoluciones();
	                    
	                  
	                    panelCentral.removeAll();
	                    
	          
	                    DefaultTableModel modeloProducto = new DefaultTableModel();
	                    modeloProducto.addColumn("ID");
	                    modeloProducto.addColumn("Nombre");
	                    modeloProducto.addColumn("Precio");
	                    JTable tablaProducto = new JTable(modeloProducto);
	                    JScrollPane scrollPaneProducto = new JScrollPane(tablaProducto);
	                    
	                    // Obtener el usuario seleccionado
	                    int filaSeleccionada = tablaUsuario.getSelectedRow();
	                    if (filaSeleccionada != -1) {
	                        Usuario u = new Usuario();
	                        u.setDni((String) tablaUsuario.getValueAt(filaSeleccionada, 0));
	                        u.setNombre((String) tablaUsuario.getValueAt(filaSeleccionada, 1));
	                        u.setApellidos((String) tablaUsuario.getValueAt(filaSeleccionada, 2));
	                        u.setNombreUsuario((String) tablaUsuario.getValueAt(filaSeleccionada, 3));
	                        u.setContraseña((String) tablaUsuario.getValueAt(filaSeleccionada, 4));
	                        
	                        
	                        actualizarTablaProducto(mapaProductosUsuario, u.getNombreUsuario(), modeloProducto);
	                        
	                       
	                        panelCentral.add(scrollPaneProducto);
	                    }
	                    
	                    
	                    panelCentral.revalidate();
	                    panelCentral.repaint();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Selecciona un usuario", "Inicio de sesión", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }
	        });
	        EliminarUsuario.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int filaSeleccionada = tablaUsuario.getSelectedRow();
					if(filaSeleccionada!=-1) {
						Usuario u = new Usuario();
						
						u.setDni((String) tablaUsuario.getValueAt(filaSeleccionada,0));  
						u.setNombre((String) tablaUsuario.getValueAt(filaSeleccionada,1));
						u.setApellidos((String) tablaUsuario.getValueAt(filaSeleccionada, 2));
						u.setNombreUsuario((String) tablaUsuario.getValueAt(filaSeleccionada,3));  
						u.setContraseña((String) tablaUsuario.getValueAt(filaSeleccionada,4));
					
						if(u!= null) {
							Map<String,List<Producto>> mapaProductosUsuario = DBManager.datosDevoluciones();
							
						 //   DBManager.añadirTrasEliminar(mapaProductosUsuario.get(u.getNombreUsuario()));
							
							DBManager.actualizarAlquileres(u.getNombreUsuario());
							DBManager.eliminarUsuario(u.getNombreUsuario(), u.getContraseña());
				
							
							modeloUsuario.removeRow(filaSeleccionada);
							panelPrincipal.revalidate();
							panelPrincipal.repaint();
						}else {
							System.out.println("El usuario es nulo");
						}
					
					
				
					}
				}
			});
	        HacerInforme.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Map<String,List<Producto>> mapaProductosUsuario = DBManager.datosDevoluciones();
					// TODO Auto-generated method stub
					int filaSeleccionada = tablaUsuario.getSelectedRow();
					if(filaSeleccionada!=-1) {
						Usuario u = new Usuario();
						
						u.setDni((String) tablaUsuario.getValueAt(filaSeleccionada,0));  
						u.setNombre((String) tablaUsuario.getValueAt(filaSeleccionada,1));
						u.setApellidos((String) tablaUsuario.getValueAt(filaSeleccionada, 2));
						u.setNombreUsuario((String) tablaUsuario.getValueAt(filaSeleccionada,3));  
						u.setContraseña((String) tablaUsuario.getValueAt(filaSeleccionada,4));
						
					JTextArea area = new JTextArea();
					CrearInforme("Informe.txt",mapaProductosUsuario.get(u.getNombreUsuario()),u,area);
					area.setEditable(false);
					area.setLineWrap(true);
					area.setWrapStyleWord(true);
					//Meter un scroll para que el texto no tenga problemas de visualizacion
					JScrollPane scroll = new JScrollPane(area);
					scroll.setPreferredSize(new Dimension(500,400));
					JOptionPane.showMessageDialog(null, scroll, String.format("Informe del usuario %s", u.getNombreUsuario()), JOptionPane.INFORMATION_MESSAGE);}
					
			
				
					
				}
			});
	        
	        AñadirProducto.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					VentanaAñadirProducto ventanaAñadirProducto = new VentanaAñadirProducto();
					
				}
			});
	       
			
			setVisible(true);
			
			
			
			
    
	
}

 public void CrearInforme(String nombre,List<Producto> lista,Usuario u,JTextArea textArea) {
	try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombre))) {
        // Escribir cada producto en el archivo
			String Titulo = String.format("\t\t Informe del usuario %s\n", u.getNombre());
			writer.write(Titulo);
			String DatosPersonales = String.format("Datos personales: %s , %s ,%s ,%s \n", u.getDni(),u.getNombre(),u.getApellidos(),u.getNombreUsuario());
	   	 	writer.write(DatosPersonales);
	   		String Productos = "Productos a su disposicion:\n";
	      	 writer.write(Productos);
        for (Producto  p : lista) {
            String string = String.format("%s,%s,%f \n",p.getId(),p.getTitulo(),p.getPrecio()); // Suponiendo que tienes una implementación adecuada de toString en Producto
            writer.write(string);
           // Agregar una nueva línea después de cada producto
        }
        System.out.println("Productos escritos en el archivo correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Error al escribir en el archivo.");
    }
		
		StringBuilder texto = new StringBuilder();
	    try (BufferedReader reader = new BufferedReader(new FileReader(nombre))) {
	        String linea;
	        while ((linea = reader.readLine()) != null) {
	            texto.append(linea).append("\n");
	        }
	    } catch (IOException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al leer el informe.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    textArea.setText(texto.toString());
	
		
	
}





public void actualizarTablaUsuario(List<Usuario> lista,DefaultTableModel modeloUsuario) {
    modeloUsuario.setRowCount(0);
   
    	
    	 for(Usuario u : lista) {
    	        modeloUsuario.addRow(new Object[] {u.getDni(), u.getNombre(), u.getApellidos(),u.getNombreUsuario(),u.getContraseña()});
    	    }
    	
    	 
    	 
    }




public void actualizarTablaProducto(Map<String,List<Producto>> mapa, String nombre_usuario ,DefaultTableModel modeloProducto) {
    modeloProducto.setRowCount(0);
   
    	
    		 List<Producto> listaProductosUsuario = mapa.get(nombre_usuario);
    		 for(Producto p:listaProductosUsuario) {
    			 modeloProducto.addRow(new Object[] {p.getId(), p.getTitulo(), p.getPrecio(), });
    		 }
    	
    	 
    	
    	
    }
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new VentanaAdministrador();
					
				
				}
			});
					}

}
