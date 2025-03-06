package Algorithm;

/**
 * Clase que proporciona un metodo alternativo para calcular 
 * el numero hexagonal de un entero dado de manera iterativa.
 * 
 * @author Daniel Diaz Garcia
 * @author Oussama Bolbaroud
 * @author Miguel Ahijon Hormigos
 * @author David Marcos Valhondo
 */
public class Algoritmo2 {

    /**
     * Calcula el numero hexagonal de un numero entero dado utilizando una suma acumulativa de
     * manera iterativa.
     * <p>
     * Un numero hexagonal se define como la suma de la secuencia:
     * <code>H(n)=&sum;<sub>i=0</sub><sup>n-1</sup>(4i+1)</code>
     * </p>
     * <p>
     * La complejidad de este algoritmo es de <code>T(n)=O(n)</code>
     * </p>
     * 
     * @param n El numero entero para calcular su numero hexagonal.
     * @return Un objeto {@link Par} que contiene el tiempo de ejecucion en nanosegundos
     *         y el resultado del calculo del numero hexagonal.
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
