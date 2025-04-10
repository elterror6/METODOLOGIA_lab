package CasoEstudio4.Interfaz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import CasoEstudio4.Negocio.Festival;
import CasoEstudio4.Negocio.IPlanificadorFestivales;
import CasoEstudio4.Negocio.PlanificadorFestivalesImp;

/**
 * Clase principal para ejecutar el algoritmo de backtracking para la planificación de festivales.
 * <p>
 * En este ejemplo se define un array de festivales con datos de ejemplo, se convierte en una lista, 
 * se ordena por el día de inicio y se ejecuta el algoritmo de backtracking considerando un presupuesto máximo
 * de 1000 €. Al finalizar, se muestra la combinación óptima de festivales, el número total de días asistidos y 
 * el presupuesto gastado.
 * </p>
 * 
 * @version 1.0
 */
public class Main {
    /**
     * Método principal que ejecuta el programa.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Definición del array de festivales (datos de ejemplo).
        Festival[] festivalsArray = new Festival[] {
            new Festival("Viñarock", 1, 10, 350),
            new Festival("Oasis Sound Festival", 3, 8, 200),
            new Festival("Mad Cool Festival", 15, 18, 60),
            new Festival("Pirineos Sur", 18, 22, 100),
            new Festival("FIB", 12, 16, 220),
            new Festival("RockLand Fest", 8, 13, 150),
            new Festival("Sonórica", 25, 28, 110),
            new Festival("Bellota Rock Fest", 20, 29, 400)
        };

        // Convertir el array en una lista para facilitar su manipulación.
        List<Festival> festivals = new ArrayList<>(Arrays.asList(festivalsArray));

        // Ordenar la lista de festivales por día de inicio.
        Collections.sort(festivals, Comparator.comparingInt(Festival::getStart));

        // Presupuesto máximo permitido (1000€).
        int budget = 1000;

        // Crear una instancia de la implementación del planificador de festivales.
        IPlanificadorFestivales planificador = new PlanificadorFestivalesImp();

        // Ejecutar el algoritmo de backtracking sobre la lista de festivales.
        planificador.backtracking(festivals, 0, 0, 0, budget, new ArrayList<>());

        // Se utiliza un cast a la implementación concreta para acceder a los getters de la solución óptima.
        PlanificadorFestivalesImp impl = (PlanificadorFestivalesImp) planificador;
        
        // Mostrar la solución óptima.
        System.out.println("Mejor combinación de festivales:");
        for (Festival f : impl.getBestFestivals()) {
            System.out.println(f);
        }
        System.out.println("Número total de días: " + impl.getBestDays());
        System.out.println("Presupuesto gastado: " + impl.getBestCost() + "€");
    }
}
