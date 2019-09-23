/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Humberto
 */
public class operaciones {

    /*
    Este Método servira para calcular A y B cuando el valor de D/d no se encuentre en la tabla
     */
    double matriz[][] = {
        {2.00, 1.01470, -0.30035},
        {1.50, 0.99957, -0.28221},
        {1.30, 0.99682, -0.25751},
        {1.20, 0.96272, -0.25527},
        {1.15, 0.98084, -0.22485},
        {1.10, 0.98450, -0.20818},
        {1.07, 0.98498, -0.19548},
        {1.05, 1.00480, -0.17076},
        {1.02, 1.01220, -0.12474},
        {1.01, 0.98413, -0.10474}
    };

    double Dd[] = {
        2.00, 1.50, 1.30, 1.20, 1.15, 1.10, 1.07, 1.05, 1.02, 1.01
    };
    
    

    public double interpolacion(double x, double x1, double x2, double y1, double y2) {
        double Y = 0;
        double rest1, rest2, rest3, div;
        rest1 = y2 - y1;
        rest2 = x2 - x1;
        rest3 = x - x1;
        div = rest1 / rest2;
        Y = y1 + (div * rest3);
        return Y;
    }

    public double calculaKt(double A, double r, double d, double b) {
        double K;
        double div, potencia;
        div = r / d;
        potencia = Math.pow(div, b);
        K = A * potencia;
        return K;
    }

    public double[] obtieneMayorMenor(double divRes) {
        double arreglo[] = new double[2];

        Double a[] = agregaDiv(divRes);
        for (int i = 0; i < a.length; i++) {
            if (divRes == a[i]) {
                arreglo[0] = a[i - 1];
                arreglo[1] = a[i + 1];
                break;
            }

        }

        return arreglo;
    }

    public double[] flujoNormal(double div) {
        double arreglo [] = new double[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (div != matriz[i][j]) {// si lo que tiene el resultado de la divisio es diferente con lo que esta en la tabla en el campo D/d
                    break;//ya no sigue buscando en la fila
                } else {
                    //si es igual el resultado con lo que hay en D/d asigna los valores de A y B                    
                    arreglo[0]= matriz[i][(j + 1)];
                    arreglo[1]= matriz[i][(j + 2)];
                    
                }
            }

        }
        
        return arreglo;
    }

    public Map<Integer, Double> obtieneAyB(double arreglo[]) {
        Map<Integer, Double> arr = new LinkedHashMap();
        int pos = 0;
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz.length; k++) {
                    if (arreglo[i] != matriz[j][k]) {
                        break;
                    } else {
                        arr.put(pos, matriz[j][k + 1]);
                        pos++;
                        arr.put(pos, matriz[j][k + 2]);
                        pos++;
                        break;
                    }
                }

            }
        }
        return arr;
    }

    public Double[] agregaDiv(double div) {
        List<Double> miArrayList = new ArrayList<Double>();

        for (int i = 0; i < Dd.length; i++) {
            miArrayList.add(Dd[i]);
        }
        miArrayList.add(div);
        Double nuevoDd[] = new Double[miArrayList.size()];
        nuevoDd = miArrayList.toArray(nuevoDd);

        nuevoDd = BubbleSort(nuevoDd);

        return nuevoDd;
    }

    public Double[] BubbleSort(Double nuevoDd[]) {
        double n = nuevoDd.length;
        double temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (nuevoDd[j - 1] > nuevoDd[j]) {

                    temp = nuevoDd[j - 1];
                    nuevoDd[j - 1] = nuevoDd[j];
                    nuevoDd[j] = temp;
                }

            }
        }

        return nuevoDd;
    }
    
    public boolean buscaDd(double div){
        boolean a = false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (div != matriz[i][j]) {// si lo que tiene el resultado de la divisio es diferente con lo que esta en la tabla en el campo D/d
                    break;//ya no sigue buscando en la fila
                } else {
                    a = true;
                    break;
                }
            }

        }
        
        return a;
    }
    
    


}
