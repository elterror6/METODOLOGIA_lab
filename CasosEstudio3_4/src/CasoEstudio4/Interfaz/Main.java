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
 * Clase principal para la ejecución del algoritmo de planificación de festivales mediante backtracking.
 * <p>
 * Esta clase lee un conjunto de festivales desde un archivo externo llamado {@code Festivales.dat}, ubicado
 * en la ruta local del usuario. El archivo debe tener una primera línea que indica el número de festivales
 * (la cual se descarta), y a continuación cada línea debe tener el siguiente formato:
 * <pre>
 * NombreFestival,DiaInicio,DiaFin,Coste
 * </pre>
 * <p>
 * Una vez cargados los festivales, se ordenan por el día de inicio y se ejecuta el algoritmo
 * de backtracking implementado en {@link PlanificadorFestivalesImp}. El objetivo es encontrar
 * la mejor combinación posible de festivales que maximice el número de días asistidos sin superar
 * un presupuesto máximo (1000€).
 * 
 * @author OUSSAMA BOLBAROUD
 * @author DANIEL DÍAZ GARCÍA
 * @version 1.1
 */
public class Main {

    /**
     * Método principal del programa. Lee el archivo de festivales, ordena los datos,
     * ejecuta el algoritmo de backtracking y muestra la solución óptima por consola.
     * 
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        List<Festival> festivals = new ArrayList<>();

        // Leer festivales desde el archivo Festivales.dat
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\oussa\\Downloads\\Festivales.dat"))) {
            // Leer y descartar la primera línea (número de festivales)
            String line = br.readLine();

            // Leer el resto de líneas con los datos de festivales
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

        // Ordenar los festivales por día de inicio para facilitar el backtracking
        Collections.sort(festivals, Comparator.comparingInt(Festival::getStart));

        // Presupuesto máximo para asistir a festivales
        int budget = 1000;

        // Crear una instancia del planificador
        IPlanificadorFestivales planificador = new PlanificadorFestivalesImp();

        // Ejecutar el algoritmo de backtracking con los datos leídos
        planificador.backtracking(festivals, 0, 0, 0, budget, new ArrayList<>());

        // Cast para acceder a los resultados obtenidos
        PlanificadorFestivalesImp impl = (PlanificadorFestivalesImp) planificador;

        // Mostrar resultados por consola
        System.out.println("Mejor combinación de festivales:");
        for (Festival f : impl.getBestFestivals()) {
            System.out.println(f);
        }
        System.out.println("Número total de días: " + impl.getBestDays());
        System.out.println("Presupuesto gastado: " + impl.getBestCost() + "€");
    }
}
