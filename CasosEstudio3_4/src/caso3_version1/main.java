package caso3;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Solado Económico ===");

        // Pedir tamaño del suelo (lado del cuadrado)
        System.out.print("Introduce el tamaño del suelo (lado en metros): ");
        int side = scanner.nextInt();

        // Pedir número de tipos de baldosas
        System.out.print("Introduce el número de tipos de baldosas: ");
        int numTipos = scanner.nextInt();

        // Pedir tamaño de cada baldosa
        ArrayList<Integer> tileSizes = new ArrayList<>();
        for (int i = 0; i < numTipos; i++) {
            System.out.print("Introduce el tamaño de la baldosa #" + (i + 1) + " (en metros): ");
            tileSizes.add(scanner.nextInt());
        }

        // Mostrar los datos recogidos
        System.out.println("\n--- Datos introducidos ---");
        System.out.println("Tamaño del suelo: " + side + " x " + side + " metros");
        System.out.println("Tamaños de baldosas disponibles (ordenados): " + tileSizes);

        // Aquí iría la llamada al algoritmo voraz 

        scanner.close();
    }
}
