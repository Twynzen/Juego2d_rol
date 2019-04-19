
package juego2d_rol;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Juego2d_rol extends Canvas {
private static final long serialVersionUID = 1L;

private static final int ANCHO = 800;
private static final int LARGO = 600; //Tamaño de la ventana

private static final String NOMBRE = "Juego"; // Nombre de la ventana

private static JFrame ventana;

public Juego2d_rol(){
    setPreferredSize(new Dimension(ANCHO, LARGO));
    
    ventana = new JFrame();
    ventana.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    ventana.setResizable(false);
    ventana.setLayout(new BorderLayout());
    ventana.add(this, BorderLayout.CENTER);
    ventana.pack();    
    ventana.setLocationRelativeTo(null);    
    ventana.setVisible(true);    
    
   
} 


}
