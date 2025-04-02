package caso3_version1;

/**
 * Clase que implementa un algoritmo voraz para resolver el problema de solado
 * de una superficie cuadrada utilizando el mínimo número de baldosas.
 * 
 * @author Implementación 
 * @version 1.0
 */
public class SoladoSuperficie {
    
    /**
     * Implementa un algoritmo voraz para determinar el número mínimo de baldosas
     * necesarias para solar una superficie cuadrada de lado n.
     * 
     * Estrategia voraz: Siempre colocar la baldosa más grande posible en cada paso.
     * 
     * @param n Longitud del lado de la superficie cuadrada a solar (en metros)
     * @param tamanosBaldosas Array con los tamaños disponibles de baldosas (ordenado de mayor a menor)
     * @return El número mínimo de baldosas según el algoritmo voraz
     */
    public static int solarSuperficieVoraz(int n, int[] tamanosBaldosas) {
        // Validación de entrada
        if (n <= 0) {
            throw new IllegalArgumentException("El tamaño de la superficie debe ser positivo");
        }
        
        if (tamanosBaldosas == null || tamanosBaldosas.length == 0) {
            throw new IllegalArgumentException("Debe haber al menos un tamaño de baldosa disponible");
        }
        
        // Ordenamos los tamaños de baldosas de mayor a menor (si no estuvieran ya ordenados)
        ordenarDescendente(tamanosBaldosas);
        
        // Matriz que representa la superficie a solar (0 significa no solado aún)
        int[][] superficie = new int[n][n];
        
        // Contador para el número de baldosas utilizadas
        int numBaldosas = 0;
        
        // Aplicamos la estrategia voraz hasta que la superficie esté completamente solada
        while (!superficieCompleta(superficie)) {
            // Encontramos la posición para la siguiente baldosa (primer hueco disponible)
            int[] posicion = encontrarPrimerHueco(superficie);
            int fila = posicion[0];
            int columna = posicion[1];
            
            // Colocamos la baldosa más grande posible en esa posición
            int tamanoMaximo = encontrarTamanoMaximoBaldosa(superficie, fila, columna, tamanosBaldosas);
            
            // Marcamos el área como solada
            colocarBaldosa(superficie, fila, columna, tamanoMaximo);
            
            // Incrementamos el contador de baldosas
            numBaldosas++;
        }
        
        return numBaldosas;
    }
    
    /**
     * Ordena un array de enteros en orden descendente.
     * 
     * @param array El array a ordenar
     */
    private static void ordenarDescendente(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    
    /**
     * Verifica si la superficie está completamente solada.
     * 
     * @param superficie Matriz que representa la superficie
     * @return true si toda la superficie está solada, false en caso contrario
     */
    private static boolean superficieCompleta(int[][] superficie) {
        for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[0].length; j++) {
                if (superficie[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Encuentra la posición del primer hueco disponible en la superficie.
     * 
     * @param superficie Matriz que representa la superficie
     * @return Array de dos enteros con la fila y columna del primer hueco
     */
    private static int[] encontrarPrimerHueco(int[][] superficie) {
        for (int i = 0; i < superficie.length; i++) {
            for (int j = 0; j < superficie[0].length; j++) {
                if (superficie[i][j] == 0) {
                    return new int[] {i, j};
                }
            }
        }
        // No debería llegar aquí si se llama correctamente
        return new int[] {-1, -1};
    }
    
    /**
     * Encuentra el tamaño máximo de baldosa que se puede colocar en una posición.
     * 
     * @param superficie Matriz que representa la superficie
     * @param fila Fila inicial donde colocar la baldosa
     * @param columna Columna inicial donde colocar la baldosa
     * @param tamanosBaldosas Array con los tamaños disponibles de baldosas
     * @return El tamaño máximo de baldosa que se puede colocar
     */
    private static int encontrarTamanoMaximoBaldosa(int[][] superficie, int fila, int columna, int[] tamanosBaldosas) {
        int n = superficie.length;
        
        // Para cada tamaño de baldosa, de mayor a menor
        for (int tamano : tamanosBaldosas) {
            // Verificamos si la baldosa cabe en la superficie desde la posición dada
            if (fila + tamano <= n && columna + tamano <= n) {
                // Verificamos si el área está disponible (no solada)
                boolean areaDisponible = true;
                
                for (int i = fila; i < fila + tamano && areaDisponible; i++) {
                    for (int j = columna; j < columna + tamano && areaDisponible; j++) {
                        if (superficie[i][j] != 0) {
                            areaDisponible = false;
                        }
                    }
                }
                
                if (areaDisponible) {
                    return tamano;
                }
            }
        }
        
        // Si llegamos aquí, solo cabe la baldosa más pequeña
        return tamanosBaldosas[tamanosBaldosas.length - 1];
    }
    
    /**
     * Coloca una baldosa en la superficie, marcando el área como solada.
     * 
     * @param superficie Matriz que representa la superficie
     * @param fila Fila inicial donde colocar la baldosa
     * @param columna Columna inicial donde colocar la baldosa
     * @param tamano Tamaño de la baldosa a colocar
     */
    private static void colocarBaldosa(int[][] superficie, int fila, int columna, int tamano) {
        for (int i = fila; i < fila + tamano; i++) {
            for (int j = columna; j < columna + tamano; j++) {
                superficie[i][j] = 1; // Marcamos como solado
            }
        }
    }
    
    /**
     * Método principal para probar el algoritmo.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Ejemplo: Solar un área de 8×8 metros con baldosas de 1×1, 2×2, 3×3, 4×4 metros
        int n = 8;
        int[] tamanosBaldosas = {4, 3, 2, 1};
        
        int resultado = solarSuperficieVoraz(n, tamanosBaldosas);
        
        System.out.println("Para solar un área de " + n + "×" + n + " metros,");
        System.out.println("con baldosas de tamaños: ");
        for (int tamano : tamanosBaldosas) {
            System.out.println("- " + tamano + "×" + tamano + " metros");
        }
        System.out.println("Se necesitan como mínimo " + resultado + " baldosas según el algoritmo voraz.");
        
        // Contraejemplo para demostrar que el algoritmo no es óptimo
        System.out.println("\nContraejemplo para demostrar que el algoritmo no es óptimo:");
        n = 5;
        tamanosBaldosas = new int[] {3, 1};  // Solo baldosas de 3×3 y 1×1
        
        resultado = solarSuperficieVoraz(n, tamanosBaldosas);
        
        System.out.println("Para solar un área de " + n + "×" + n + " metros con baldosas de 3×3 y 1×1:");
        System.out.println("El algoritmo voraz usa " + resultado + " baldosas.");
        System.out.println("La solución óptima usaría 4 baldosas (una de 3×3 y tres de 2×2).");
    }
}
