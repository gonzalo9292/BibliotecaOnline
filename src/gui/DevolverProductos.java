package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DevolverProductos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
public DevolverProductos() {
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setSize(700, 500);
       setTitle("DevolverProductos");
       
       setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2),  
               (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2));
       
       setIconImage((new ImageIcon("resorces/images/iconos/icono.png").getImage()));
       
       
       JPanel panelPrincipal = new JPanel(new BorderLayout());
       JPanel panelNorte = new JPanel(new GridLayout(1,3));
       
       
       
       
	
}
	

}
