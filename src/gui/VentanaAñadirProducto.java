package gui;

import java.awt.BorderLayout;
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
import javax.swing.SwingUtilities;

public class VentanaA�adirProducto extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public VentanaA�adirProducto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(700, 500);
		setTitle("BibliotecaOnline");
	
	    setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
	            (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
		
	    setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
	    

		JPanel panelPrincipal = new JPanel(new BorderLayout());
		add(panelPrincipal);
		
		JPanel panelNorte = new JPanel();
		panelPrincipal.add(panelNorte,BorderLayout.NORTH);
		JLabel tituloLabel = new JLabel("Selecciona el tipo de producto");
		
		Font fuente = new Font("Arial",Font.BOLD,20);
        tituloLabel.setFont(fuente);
        panelNorte.add(tituloLabel);
		
		
		JPanel panelCentral = new JPanel(new GridLayout(3,1));
		panelPrincipal.add(panelCentral,BorderLayout.CENTER);
		
		
		JButton Libro = new JButton("Libro");
		JButton Juego = new JButton("Juego");
		JButton Pelicula = new JButton("Pelicula");
		
		
		ImageIcon icono = new ImageIcon("resorces/images/iconos/libro.png");
		Libro.setIcon(icono);
		ImageIcon icono2 = new ImageIcon("resorces/images/iconos/mandoDeJuego.png");
		Juego.setIcon(icono2);
		ImageIcon icono3 = new ImageIcon("resorces/images/iconos/camara.png");
		Pelicula.setIcon(icono3);
		
		panelCentral.add(Libro);
		panelCentral.add(Juego);
		panelCentral.add(Pelicula);
		
		
		
		Libro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VentanaA�adirLibro ventanaA�adirLibro = new VentanaA�adirLibro();
				
			}
		});
		
		Juego.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VentanaA�adirJuego ventanaA�adirJuego = new VentanaA�adirJuego();
				
			}
		});
		
		Pelicula.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VentanaA�adirPelicula ventanaA�adirPelicula = new VentanaA�adirPelicula();
				
			}
		});
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					new VentanaA�adirProducto();
					
				
				}
			});
					}

}
