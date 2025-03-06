package Algorithm;

/**
 * Clase que proporciona un método para calcular el número hexagonal de un entero dado.
 */
public class Algoritmo1 {

    /**
     * Calcula el número hexagonal de un número entero dado.
     * <p>
     * Un número hexagonal se define por la fórmula: 
     * {@code H(n) = n * (2n - 1)}
     * </p>
     * 
     * @param n El número entero para calcular su número hexagonal.
     * @return Un objeto {@link Par} que contiene el tiempo de ejecución en nanosegundos
     *         y el resultado del cálculo del número hexagonal.
     */
    public static Par calcularHexagonal(int n) {
        int result;
        Par pair = null;
        long t0, t1, deltaT;
        
        t0 = System.nanoTime();
        result = n * (2 * n - 1);
        t1 = System.nanoTime();
        
        deltaT = t1 - t0;
        pair = new Par(deltaT, result);
        
        return pair;
    }
}
