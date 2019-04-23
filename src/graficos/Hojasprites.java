
package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Hojasprites {
    
    final int ancho;
    final int alto;
    public final int [] pixeles;

    public Hojasprites(final String ruta, int ancho, int alto)  {
        
        this.ancho = ancho;
        this.alto = alto;
       
        pixeles = new int[ancho * alto];
        
        BufferedImage imagen;
        try {
            imagen = ImageIO.read(Hojasprites.class.getResource(ruta));
            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    

}
