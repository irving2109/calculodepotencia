import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CalculodePotencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> resultados = new ArrayList<>();

        while (true) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Círculo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triángulo");
            System.out.println("4. Rectángulo");
            System.out.println("5. Pentágono");
            System.out.println("6. Potencia");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = obtenerEntero(scanner);

            if (opcion == 7) {
                System.out.println("Saliendo del programa.");
                break;
            }

            double resultado = 0;

            switch (opcion) {
                case 1:
                    resultado = operacionCirculo(scanner);
                    break;
                case 2:
                    resultado = operacionCuadrado(scanner);
                    break;
                case 3:
                    resultado = operacionTriangulo(scanner);
                    break;
                case 4:
                    resultado = operacionRectangulo(scanner);
                    break;
                case 5:
                    resultado = operacionPentagono(scanner);
                    break;
                case 6:
                    resultado = operacionPotencia(scanner);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    continue;
            }


