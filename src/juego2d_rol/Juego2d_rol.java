
package juego2d_rol;

import control.Teclado;
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

private static int aps = 0;
private static int fps = 0;

private static JFrame ventana;
private static Thread thread; //Creamos un thread para el procesador
private static Teclado teclado;

public Juego2d_rol(){
    setPreferredSize(new Dimension(ANCHO, LARGO));
    
    teclado = new Teclado();
    addKeyListener(teclado);//pedimos que detecte todo lo que se utilice en esta clase por teclado
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
    public void actualizar(){//Datos, variables estadisticas del juego 
        teclado.actualizar();
        if(teclado.arriba){
            System.out.println("Arriba");
        }
        if (teclado.abajo) {
            System.out.println("Abajo");
        }
        if (teclado.izquierda) {
            System.out.println("Izquierda");
        }
        if (teclado.derecha) {
            System.out.println("Derecha");
        }
        
        aps++;
    }
   
    private void mostrar(){ //pinta los graficos del juego
        fps++;
    }
    
    
    
    @Override
    public void run() {
        final int NS_POR_SEGUNDO =1000000000; //nanosegundos de un segundo
        final byte APS_OBJETIVO = 60; //Las actualizaciones que queremos llevar por segundo
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
        
        long referenciaActualizacion = System.nanoTime(); //se atribuye una cantidad de tiempo en nanosegundos
        long referenciaContador = System.nanoTime();
        double  tiempoTranscurrido;
        double delta = 0 ; //delta es la cantidad de tiempo que pasa hasta que se actualiza
        
        requestFocus();
        
        
        System.nanoTime();//mide de el tiempo segun los ciclos de relog del micro-procesador 1.5version
        while (enFuncionamiento){
            final long inicioBucle = System.nanoTime();
            
            tiempoTranscurrido = inicioBucle - referenciaActualizacion;//acciona la medición de la actualizacion
            referenciaActualizacion = inicioBucle; // mide el cambio entre el cada referencia de actualización
            
            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            
            while(delta>=1){ //Se encarga de repetir el proceso
                actualizar(); 
                delta--;
            }
            
            
            mostrar();
            if(System.nanoTime()-referenciaContador > NS_POR_SEGUNDO){
                ventana.setTitle(NOMBRE + " || APS: " + aps +" || FPS: "+ fps);
                aps=0;
                fps=0;
                referenciaContador = System.nanoTime();
            }
            
        }
    }


}
