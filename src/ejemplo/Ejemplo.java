/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Humberto
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        operaciones o = new operaciones();
        double D, d, r;

        D = Double.parseDouble(JOptionPane.showInputDialog("Deme el valor de D"));
        d = Double.parseDouble(JOptionPane.showInputDialog("Deme el valor de d"));
        r = Double.parseDouble(JOptionPane.showInputDialog("Deme el valor de r"));

        double div = D / d;

        if (o.buscaDd(div)) {
            double arreglo[] = o.flujoNormal(div);
        } else {
            double arreglo[] = o.obtieneMayorMenor(div);
            Map<Integer, Double> map = o.obtieneAyB(arreglo);
            double a = o.interpolacion(div, arreglo[1], arreglo[0], map.get(2), map.get(0));
            double b = o.interpolacion(div, arreglo[1], arreglo[0], map.get(3), map.get(1));
            System.out.println(a + "\n" + b+ "\n" + div);
        }

    }

}
