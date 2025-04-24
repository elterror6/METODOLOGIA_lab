package CasoEstudio4.Interfaz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import CasoEstudio4.Negocio.Festival;
import CasoEstudio4.Negocio.IPlanificadorFestivales;
import CasoEstudio4.Negocio.PlanificadorFestivalesImp;


/**
 * Clase principal que lee los festivales desde Festivales.dat y ejecuta
 * el algoritmo de backtracking para encontrar la mejor combinación.
 */
public class Main {

    public static void main(String[] args) {
        List<Festival> festivals = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\oussa\\Downloads\\Festivales.dat"))) {
            // Leer y descartar la primera línea (número de festivales)
            String line = br.readLine();

            // Leer el resto de líneas con los festivales
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    int start = Integer.parseInt(parts[1].trim());
                    int end = Integer.parseInt(parts[2].trim());
                    int cost = Integer.parseInt(parts[3].trim());
                    festivals.add(new Festival(name, start, end, cost));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        // Ordenar festivales por día de inicio
        Collections.sort(festivals, Comparator.comparingInt(Festival::getStart));

        // Presupuesto máximo
        int budget = 1000;

        // Crear instancia del planificador
        IPlanificadorFestivales planificador = new PlanificadorFestivalesImp();

        // Ejecutar algoritmo de backtracking
        planificador.backtracking(festivals, 0, 0, 0, budget, new ArrayList<>());

        // Obtener resultados
        PlanificadorFestivalesImp impl = (PlanificadorFestivalesImp) planificador;

        // Imprimir resultados
        System.out.println("Mejor combinación de festivales:");
        for (Festival f : impl.getBestFestivals()) {
            System.out.println(f);
        }
        System.out.println("Número total de días: " + impl.getBestDays());
        System.out.println("Presupuesto gastado: " + impl.getBestCost() + "€");
    }
}
