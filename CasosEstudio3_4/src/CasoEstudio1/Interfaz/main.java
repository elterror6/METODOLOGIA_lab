package CasoEstudio1.Interfaz;

import CasoEstudio1.Negocio.GreedyAlgorithm;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Solado Económico ===");

        // Pedir tamaño del suelo (lado del cuadrado)
        System.out.print("Introduce el tamaño del suelo (lado en metros): ");
        int size = scanner.nextInt();
        int [][] floor;

        // Pedir número de tipos de baldosas
        System.out.print("Introduce el número de tipos de baldosas: ");
        int numTipos = scanner.nextInt();

        // Pedir tamaño de cada baldosa
        Integer [] tileSizes = new Integer [numTipos];
        for (int i = 0; i < numTipos; i++) {
            System.out.print("Introduce el tamaño de la baldosa #" + (i + 1) + " (en metros): ");
            tileSizes[i] = scanner.nextInt();
        }

        // Mostrar los datos recogidos
        System.out.println("\n--- Datos introducidos ---");
        System.out.println("Tamaño del suelo: " + size + " x " + size + " metros");
        
        floor =  GreedyAlgorithm.tileFloor(tileSizes, size);
        for(int i = 0; i<floor.length; i++) {
        	for(int j = 0; j<floor[i].length;j++) {
        		System.out.print(floor[i][j]+" ");
        	}
        	System.out.println();
        }
        // Aquí iría la llamada al algoritmo voraz 

        scanner.close();
    }
}
