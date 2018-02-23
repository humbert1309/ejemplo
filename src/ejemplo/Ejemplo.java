/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Humberto
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double arreglo[] = {1.20, 1.15};
        operaciones o = new operaciones();
        Map<Integer,Double> map = o.obtieneAyB(arreglo);
        double a = o.interpolacion(1.187, 1.20, 1.15, 0.96272, 0.98084);
        double b = o.interpolacion(1.187, 1.20, 1.15, -0.25527, -0.22485);
        System.out.println("**************************RESULTADO*************************************");
        System.out.println("D/d = " + 1.187);
        System.out.println("A = " + o.interpolacion(1.187, 1.20, 1.15, 0.96272, 0.98084));
        System.out.println("B = " + o.interpolacion(1.187, 1.20, 1.15, -0.25527, -0.22485));
        System.out.println("Kt = " + o.calculaKt(a, 3, 32, b));
       
        System.out.println("A = " + o.interpolacion(1.187, arreglo[0], arreglo[1], map.get(0), map.get(2)));
        System.out.println("B = " + o.interpolacion(1.187, arreglo[0], arreglo[1], map.get(1), map.get(3)));
            
        
    }

}
