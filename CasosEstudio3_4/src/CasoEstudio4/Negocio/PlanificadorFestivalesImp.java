package CasoEstudio4.Negocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Implementación de la interfaz IPlanificadorFestivales.
 * <p>
 * Esta clase contiene la lógica del algoritmo de backtracking para planificar festivales,
 * determinando la combinación óptima de festivales que maximiza la cantidad de días sin exceder
 * un presupuesto dado.
 * </p>
 * 
 * @version 1.0
 */
public class PlanificadorFestivalesImp implements IPlanificadorFestivales {

    private int bestDays;
    private int bestCost;
    private List<Festival> bestFestivals;

    /**
     * Constructor que inicializa las variables de la solución.
     */
    public PlanificadorFestivalesImp() {
        bestDays = 0;
        bestCost = 0;
        bestFestivals = new ArrayList<>();
    }

    @Override
    public List<Festival> readFestivales(String fileName) {
        List<Festival> festivals = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            // Se lee la primera línea (número de festivales) y se ignora o se utiliza según convenga
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                try {
                    Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    // Si la primera línea no es numérica, se ignora el error
                }
                // Lectura de cada línea
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine().trim();
                    if (line.isEmpty()) continue;
                    String[] datos = line.split(",");
                    if (datos.length < 4) continue;
                    String nombre = datos[0].trim();
                    int inicio = Integer.parseInt(datos[1].trim());
                    int fin = Integer.parseInt(datos[2].trim());
                    int precio = Integer.parseInt(datos[3].trim());
                    festivals.add(new Festival(nombre, inicio, fin, precio));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + fileName);
        }
        return festivals;
    }

    @Override
    public void backtracking(List<Festival> festivals, int index, int currentCost, int currentDays, int budget, List<Festival> currentList) {
        // Actualiza la mejor solución si se mejora el número de días
        if (currentDays > bestDays) {
            bestDays = currentDays;
            bestCost = currentCost;
            bestFestivals = new ArrayList<>(currentList);
        }
        // Fin de la recursión: se han evaluado todos los festivales
        if (index >= festivals.size()) {
            return;
        }
        // Recorrer festivales desde el índice actual
        for (int i = index; i < festivals.size(); i++) {
            Festival f = festivals.get(i);
            if (esCompatible(currentList, f)) {
                if (currentCost + f.getPrice() <= budget) {
                    currentList.add(f);
                    backtracking(festivals, i + 1, currentCost + f.getPrice(), currentDays + f.getDays(), budget, currentList);
                    // Retroceder: se elimina el último festival añadido para evaluar otras posibilidades
                    currentList.remove(currentList.size() - 1);
                }
            }
        }
    }

    @Override
    public boolean esCompatible(List<Festival> selectedLista, Festival candidate) {
        for (Festival f : selectedLista) {
            if (seSolapan(f, candidate)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean seSolapan(Festival f1, Festival f2) {
        // Dos festivales son compatibles si uno termina antes de que el otro comience
        return !(f1.getEnd() < f2.getStart() || f2.getEnd() < f1.getStart());
    }

    @Override
    public void planificarFestivales(String fileName, int budget) {
        List<Festival> festivals = readFestivales(fileName);
        if (festivals.isEmpty()) {
            System.out.println("No se han encontrado festivales en el archivo " + fileName);
            return;
        }
        // Ordenar los festivales por día de inicio
        Collections.sort(festivals, Comparator.comparingInt(Festival::getStart));
        // Ejecutar el algoritmo de backtracking
        backtracking(festivals, 0, 0, 0, budget, new ArrayList<>());
        // Mostrar la solución óptima
        System.out.println("Mejor combinación de festivales:");
        for (Festival f : bestFestivals) {
            System.out.println(f);
        }
        System.out.println("Número total de días: " + bestDays);
        System.out.println("Presupuesto gastado: " + bestCost + "€");
    }

    /**
     * Devuelve la lista de festivales correspondiente a la mejor solución encontrada.
     * 
     * @return lista de festivales óptima.
     */
    public List<Festival> getBestFestivals() {
        return bestFestivals;
    }

    /**
     * Devuelve el número total de días de la mejor solución.
     * 
     * @return número total de días.
     */
    public int getBestDays() {
        return bestDays;
    }

    /**
     * Devuelve el costo total de la mejor solución.
     * 
     * @return presupuesto gastado.
     */
    public int getBestCost() {
        return bestCost;
    }
}

