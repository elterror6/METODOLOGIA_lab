package CasoEstudio1;

import java.util.Scanner;
import Algorithm.*;

/**
 * Clase principal que permite al usuario calcular números hexagonales
 * utilizando diferentes métodos: fórmula fija, iterativo y recursivo.
 */
public class Main {

    /**
     * Método principal que ejecuta un menú interactivo para calcular números hexagonales.
     * El usuario puede elegir entre tres métodos distintos de cálculo y ver los tiempos de ejecución.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
       
        String menu = "Cálculo de números hexagonales\n_______________________________\n"
                    + "\t1) Cálculo con fórmula fija.\n"
                    + "\t2) Cálculo de manera iterativa.\n"
                    + "\t3) Cálculo de manera recursiva.\n"
                    + "\t4) Salir\n"
                    + "¿Qué opción quiere escoger? ";
                    
        String icc = "Cálculo de número hexagonal con ecuación cerrada\n"
                   + "________________________________________________\n"
                   + "¿Cuál número hexagonal desea calcular? ";
                   
        String ici = "Cálculo de número hexagonal de forma iterativa\n"
                   + "______________________________________________\n"
                   + "¿Cuál número hexagonal desea calcular? ";
                   
        String icr = "Cálculo de número hexagonal de forma recursiva\n"
                   + "______________________________________________\n"
                   + "¿Cuál número hexagonal desea calcular? ";
        
        
        Interfaz interfaz = new Interfaz(menu);
        int option = 0, n;
        Par pair;
        Scanner in = new Scanner(System.in);
        
        do {
            n = 0;
            pair = null;
            interfaz.setInterface(menu);
            System.out.println(interfaz.getInterface());
            option = in.nextInt();
            
            switch (option) {
                case 1:
                    interfaz.setInterface(icc);
                    System.out.println(interfaz.getInterface());
                    n = in.nextInt();
                    pair = Algoritmo1.calcularHexagonal(n);
                    System.out.println("Resultado: " + pair.getN() + " [" + pair.getTime() + "ns]");
                    break;
                    
                case 2:
                    interfaz.setInterface(ici);
                    System.out.println(interfaz.getInterface());
                    n = in.nextInt();
                    pair = Algoritmo2.calcularHexagonal(n);
                    System.out.println("Resultado: " + pair.getN() + " [" + pair.getTime() + "ns]");
                    break;
                    
                case 3:
                    interfaz.setInterface(icr);
                    System.out.println(interfaz.getInterface());
                    n = in.nextInt();
                    pair = Algoritmo3.calcularHexagonal(n);
                    System.out.println("Resultado: " + pair.getN() + " [" + pair.getTime() + "ns]");
                    break;
                    
                case 4:
                    System.out.println("Goodbye.");
                    break;
                    
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 4);
        
        in.close(); 
    }
}
