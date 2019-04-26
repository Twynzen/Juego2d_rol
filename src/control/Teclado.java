
package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public final class Teclado implements KeyListener{ //array de booleanos
    
    private final static int numeroTeclas = 120;
    private final boolean[]teclas = new boolean[numeroTeclas];

    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    
    public void actualizar(){
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
       teclas[ke.getKeyCode()]= true;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       teclas[ke.getKeyCode()]= false; 
    }

    @Override
    public void keyReleased(KeyEvent ke) {
            //NONE :V
    }
    
}
