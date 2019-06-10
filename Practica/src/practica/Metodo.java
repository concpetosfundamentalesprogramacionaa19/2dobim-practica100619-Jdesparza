/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Metodo {

    // lee registro del archivo
    public static void leerRegistrosGoalsHeigth() {

        // 1. Se abre el archivo
        try // lee registros del archivo, usando el objeto Scanner
        {
            Scanner entrada = new Scanner(new File("data/"
                    + "tabula-FWC_2018_Squadlists_4.csv"));
            // declaración de variables e inicializacion de las mismas
            double sum_goals = 0;
            double sum_heigth = 0;
            int contador = 0;
            // para recorrer los valores e ir sumando, a la vez que se lo usa
            // para aumentar el contador
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                // System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split("\\|")));
                // para buscar una linea y usar su valor
                double heigth = Double.parseDouble(linea_partes.get(9));
                double goals = Double.parseDouble(linea_partes.get(11));
                // se suma los valores de las lineas 9 y 11 o conocidas 
                // tambien como Heigth y Goals
                sum_heigth = sum_heigth + heigth;
                sum_goals = sum_goals + goals;
                // se aumenta el contador
                contador = contador + 1;
            } // fin de while
            entrada.close();
            // operación para calcular el promedio de Goals y Heigth
            double prom_heigth = (sum_heigth / contador);
            double prom_goals = (sum_goals / contador);
            // mensaje con los promedios calculados
            System.out.printf("El promedio de Heigth es: %.2f\n\t"
                    + "El promedio de Goals es: %.2f\n",
                    prom_heigth, prom_goals);
        } // fin de try
        catch (Exception e) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch  

    } // fin del m�todo leerRegistrosGoalsHeigth
    // cierra el archivo y termina la aplicaci�n
}
