package Algorithm;

/**
 * Clase que proporciona un método recursivo para calcular el número hexagonal de un entero dado.
 */
public class Algoritmo3 {

    /**
     * Método recursivo para calcular el número hexagonal de un número entero.
     * <p>
     * La función se basa en la ecuación recursiva:
     * {@code F(n) = (4 * n - 3) + F(n - 1)}, con el caso base {@code F(1) = 1}.
     * </p>
     * 
     * @param n El número entero para calcular su número hexagonal.
     * @return El número hexagonal calculado recursivamente.
     */
    private static int F(int n) {
        if (n == 1) {
            return 1;
        }
        return (4 * n - 3) + F(n - 1); 
    } 

    /**
     * Calcula el número hexagonal de un número entero dado utilizando una implementación recursiva.
     * <p>
     * Mide el tiempo de ejecución del cálculo utilizando {@link System#nanoTime()}.
     * </p>
     * 
     * @param n El número entero para calcular su número hexagonal.
     * @return Un objeto {@link Par} que contiene el tiempo de ejecución en nanosegundos
     *         y el resultado del cálculo del número hexagonal.
     */
    public static Par calcularHexagonal(int n) {
        int result = 0;
        long t0, t1, deltaT;
        Par pair = null;
        
        t0 = System.nanoTime();
        result = F(n);
        t1 = System.nanoTime();
        
        deltaT = t1 - t0;
        pair = new Par(deltaT, result);
        
        return pair;
    }
}
