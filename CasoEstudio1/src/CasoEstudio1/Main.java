package CasoEstudio1;

import java.util.Scanner;
import Algorithm.*;

/**
 * Clase principal que permite al usuario calcular numeros hexagonales
 * utilizando diferentes metodos: formula fija - ({@link Algoritmo1}), iterativo - ({@link Algoritmo2}) y recursivo - ({@link Algoritmo3}).
 * 
 * @author Daniel Diaz Garcia
 * @author Oussama Bolbaroud
 * @author Miguel Ahijon Hormigos
 * @author David Marcos Valhondo
 */
public class Main {

    /**
     * Metodo principal que ejecuta un menu interactivo para calcular numeros hexagonales.
     * El usuario puede elegir entre tres mÃ©todos distintos de calculo y ver los tiempos de
     * ejecucion.
     *
     * @param args Argumentos de linea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
       
        String menu = "Calculo de numeros hexagonales\n_______________________________\n"
                    + "\t1) Calculo con formula fija.\n"
                    + "\t2) Calculo de manera iterativa.\n"
                    + "\t3) Calculo de manera recursiva.\n"
                    + "\t4) Salir\n"
                    + "Â¿Que opcion quiere escoger? ";
                    
        String icc = "Calculo de numero hexagonal con ecuacion cerrada\n"
                   + "________________________________________________\n"
                   + "¿Cual numero hexagonal desea calcular? ";
                   
        String ici = "Calculo de numero hexagonal de forma iterativa\n"
                   + "______________________________________________\n"
                   + "¿Cual numero hexagonal desea calcular? ";
                   
        String icr = "Calculo de numero hexagonal de forma recursiva\n"
                   + "______________________________________________\n"
                   + "¿Cual numero hexagonal desea calcular? ";
        
        
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
                    System.out.println("OpciÃ³n no vÃ¡lida.");
            }
        } while (option != 4);
        
        in.close(); 
    }
}
