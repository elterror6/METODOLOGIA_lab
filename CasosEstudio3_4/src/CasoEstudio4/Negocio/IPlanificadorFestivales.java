package CasoEstudio4.Negocio;

import java.util.List;

/**
 * Interfaz que define los métodos necesarios para planificar festivales.
 * <p>
 * Esta interfaz establece las operaciones requeridas para la planificación de festivales,
 * incluyendo la lectura de datos desde un fichero, el proceso de backtracking y la verificación
 * de compatibilidad entre festivales.
 * </p>
 * 
 * @version 1.0
 */
public interface IPlanificadorFestivales {

    /**
     * Lee la información de los festivales a partir de un fichero.
     * 
     * @param fileName nombre del fichero con los datos.
     * @return Lista de festivales leídos del fichero.
     */
    List<Festival> readFestivales(String fileName);

    /**
     * Método recursivo de backtracking para buscar la solución óptima.
     * 
     * @param festivals   Lista de festivales disponibles.
     * @param index       Posición actual en la lista.
     * @param currentCost Costo acumulado en la solución parcial.
     * @param currentDays Días acumulados en la solución parcial.
     * @param budget      Presupuesto máximo permitido.
     * @param currentList Lista de festivales seleccionados hasta el momento.
     */
    void backtracking(List<Festival> festivals, int index, int currentCost, int currentDays, int budget, List<Festival> currentList);

    /**
     * Comprueba si el festival candidato es compatible con la lista de festivales seleccionados.
     * 
     * @param selectedLista Lista de festivales ya seleccionados.
     * @param candidate     Festival candidato a incluir.
     * @return {@code true} si es compatible, {@code false} en caso contrario.
     */
    boolean esCompatible(List<Festival> selectedLista, Festival candidate);

    /**
     * Determina si dos festivales se solapan en sus fechas.
     * 
     * @param f1 Primer festival.
     * @param f2 Segundo festival.
     * @return {@code true} si se solapan, {@code false} en caso contrario.
     */
    boolean seSolapan(Festival f1, Festival f2);

    /**
     * Ejecuta el proceso completo de planificación: lee el fichero de datos, 
     * ejecuta el algoritmo de backtracking y muestra la solución óptima.
     * 
     * @param fileName nombre del fichero con los datos.
     * @param budget   presupuesto máximo permitido.
     */
    void planificarFestivales(String fileName, int budget);
}

