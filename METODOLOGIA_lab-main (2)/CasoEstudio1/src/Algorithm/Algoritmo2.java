package Algorithm;

/**
 * Clase que proporciona un método alternativo para calcular el número hexagonal de un entero dado.
 */
public class Algoritmo2 {

    /**
     * Calcula el número hexagonal de un número entero dado utilizando una suma acumulativa.
     * <p>
     * Un número hexagonal se define como la suma de la secuencia:
     * {@code H(n) = 1 + 5 + 9 + 13 + ...} hasta el término correspondiente a {@code n}.
     * </p>
     * 
     * @param n El número entero para calcular su número hexagonal.
     * @return Un objeto {@link Par} que contiene el tiempo de ejecución en nanosegundos
     *         y el resultado del cálculo del número hexagonal.
     */
    public static Par calcularHexagonal(int n) {
        int resultado = 0;
        long t0, t1, deltaT;
        Par pair = null;
        
        t0 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            resultado += (4 * i + 1);
        }
        t1 = System.nanoTime();
        
        deltaT = t1 - t0;
        pair = new Par(deltaT, resultado);
        
        return pair;
    }
}
