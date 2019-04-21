
package juego2d_rol;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Juego2d_rol extends Canvas implements Runnable{
private static final long serialVersionUID = 1L;

private static final int ANCHO = 800;
private static final int LARGO = 600; //Tamaño de la ventana

private static volatile boolean enFuncionamiento = false; //se agrega el volatile para que la variable no pueda ser usada por2 threads al tiempo

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

   
    public synchronized void iniciar(){ //synchronized para que se sincronice el thread al momento de ser procesado
        enFuncionamiento = true;
        
        thread = new Thread(this, "Graficos"); //aquí definimos donde se inicia y cómo se llama el thread
        thread.start();//aquí iniciamos el thread un espacio en proceso de memoria
    }
    private synchronized void detener(){
    
        enFuncionamiento = false;
     try {   
        thread.join(); //espera a que el thread temrine lo que hace y luego lo de tiene
    } catch (InterruptedException e) {
        e.printStackTrace(); //ayuda a ver el posible error en consola por el thread.join
    }
   }

    @Override
    public void run() {
        while (enFuncionamiento){
            
        }
    }


}
