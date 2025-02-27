package Hito1;

import java.util.Scanner;

public class Algoritmo_3 {
    public static int F(int n) {
        if (n == 1) {
            return 1;
        }
        return (4 * n - 3) + F(n - 1); 
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero positivo: ");
        int n = scanner.nextInt();

        if (n > 0) {
            int resultado = F(n);
            System.out.println("El resultado de F(" + n + ") es: " + resultado);
        } else {
            System.out.println("Por favor, ingrese un número positivo.");
        }
        
        scanner.close();
    }
}

