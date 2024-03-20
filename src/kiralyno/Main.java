
package kiralyno;

import java.io.IOException;


public class Main {

 
    public static void main(String[] args) throws IOException {
        Tabla tabla = new Tabla();
       
        System.out.println(tabla.megjelenit()); 
        tabla.elhelyez(64);
       System.out.println(tabla.megjelenit());
        tabla.megjelenit();
        tabla.uresOszlopokSzama();
           tabla.uresSorokSzama();
           tabla.fajlbaIr();
           
           
           
        
        
        
        
        
    }
    
}
