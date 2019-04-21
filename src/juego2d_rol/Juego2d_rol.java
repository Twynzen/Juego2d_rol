
package juego2d_rol;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Juego2d_rol extends Canvas implements Runnable{
private static final long serialVersionUID = 1L;

private static final int ANCHO = 800;
private static final int LARGO = 600; //Tamaño de la ventana

private static final String NOMBRE = "Juego"; // Nombre de la ventana

private static JFrame ventana;
private static Thread thread; //Creamos un thread para el procesador

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

   
    public void iniciar(){
        thread = new Thread(this, "Graficos"); //aquí definimos donde se inicia y cómo se llama el thread
        thread.start();//aquí iniciamos el thread un espacio en proceso de memoria
    }
    private void detener(){
        
    }

    @Override
    public void run() {
        System.out.println("El thread graficos se inicia con exito");
    }


}
