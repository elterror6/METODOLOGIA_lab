package Prueba;

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;

	/**
	 * Clase que implementa un algoritmo para contar inversiones en un array 
	 * utilizando el paradigma de Divide y Vencerás con una complejidad O(n log n).
	 */
	public class ContadorInversiones {
		
		private static final String FILE = "./InversionesTest_12.dat";
	    
	    /**
	     * Método principal para contar las inversiones en el array.
	     * @param arr El array de entrada.
	     * @return Número de inversiones en el array.
	     */
	    public static int contarInversiones(int[] arr) {
	        int[] aux = new int[arr.length]; // Array auxiliar para la fusión
	        return mergeSortContar(arr, aux, 0, arr.length - 1);
	    }
	    
	    /**
	     * Implementación del Merge Sort modificado para contar inversiones.
	     * @param arr  Array original
	     * @param aux  Array auxiliar
	     * @param izq  Índice izquierdo
	     * @param der  Índice derecho
	     * @return Número de inversiones
	     */
	    private static int mergeSortContar(int[] arr, int[] aux, int izq, int der) {
	        if (izq >= der) {
	            return 0; // Caso base: un solo elemento no tiene inversiones
	        }

	        int medio = (izq + der) / 2;
	        int inversiones = 0;

	        // Contar inversiones en la mitad izquierda
	        inversiones += mergeSortContar(arr, aux, izq, medio);

	        // Contar inversiones en la mitad derecha
	        inversiones += mergeSortContar(arr, aux, medio + 1, der);

	        // Contar inversiones en la fase de fusión
	        inversiones += fusionarContar(arr, aux, izq, medio, der);

	        return inversiones;
	    }

	    /**
	     * Fusión de dos mitades ordenadas, contando inversiones.
	     * @param arr   Array original
	     * @param aux   Array auxiliar
	     * @param izq   Índice izquierdo
	     * @param medio Índice medio
	     * @param der   Índice derecho
	     * @return Número de inversiones
	     */
	    private static int fusionarContar(int[] arr, int[] aux, int izq, int medio, int der) {
	        for (int i = izq; i <= der; i++) {
	            aux[i] = arr[i];
	        }

	        int i = izq, j = medio + 1, k = izq;
	        int inversiones = 0;

	        while (i <= medio && j <= der) {
	            if (aux[i] <= aux[j]) {
	                arr[k++] = aux[i++];
	            } else {
	                arr[k++] = aux[j++];
	                inversiones += (medio - i + 1); // Cuenta las inversiones
	            }
	        }

	        while (i <= medio) {
	            arr[k++] = aux[i++];
	        }

	        return inversiones;
	    }

	    /**
	     * Método para leer un archivo y convertirlo en un array de enteros.
	     * @param filePath Ruta del archivo a leer.
	     * @return Array de enteros leído del archivo.
	     */
	    public static int[] leerArchivo() {
	        try {
	            File file = new File(FILE);
	            Scanner scanner = new Scanner(file);
	            
	            // Leer los números del archivo
	            StringBuilder sb = new StringBuilder();
	            while (scanner.hasNext()) {
	                sb.append(scanner.next()).append(" ");
	            }
	            scanner.close();
	            
	            // Convertir los números en un array de enteros
	            String[] numerosStr = sb.toString().trim().split("\\s+");
	            int[] numeros = new int[numerosStr.length];
	            for (int i = 0; i < numerosStr.length; i++) {
	                numeros[i] = Integer.parseInt(numerosStr[i]);
	            }
	            
	            return numeros;
	        } catch (FileNotFoundException e) {
	            System.err.println("Error: Archivo no encontrado.");
	            return new int[0];
	        } catch (NumberFormatException e) {
	            System.err.println("Error: Formato incorrecto en el archivo.");
	            return new int[0];
	        }
	    }

	    /**
	     * Método principal para ejecutar el programa.
	     */
	    public static void main(String[] args) {

	        int[] array = leerArchivo();

	        if (array.length > 0) {
	            System.out.println("Número de inversiones: " + contarInversiones(array));
	        } else {
	            System.out.println("No se pudieron leer los datos correctamente.");
	        }
	    }
	}
