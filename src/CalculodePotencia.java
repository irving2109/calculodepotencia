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

            resultados.add(resultado);
            System.out.println("Resultado: " + resultado);
        }

        scanner.close();

        // Mostrar los resultados almacenados
        System.out.println("\nResultados almacenados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println("Operación " + (i + 1) + ": " + resultados.get(i));
        }
    }

    private static int obtenerEntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número entero válido.");
                scanner.next(); // Consumir la entrada no válida
            }
        }
    }

    private static double obtenerDoble(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número decimal válido.");
                scanner.next(); // Consumir la entrada no válida
            }
        }
    }

    private static double operacionCirculo(Scanner scanner) {
        double radio = obtenerDoble(scanner, "Ingrese el radio del círculo: ");
        System.out.println("Seleccione la operación:");
        System.out.println("1. Calcular área");
        System.out.println("2. Calcular perímetro");
        int opcionOperacion = obtenerEntero(scanner);
        if (opcionOperacion == 1) {
            return Circulo.calcularArea(radio);
        } else {
            return Circulo.calcularPerimetro(radio);
        }
    }

    private static double operacionCuadrado(Scanner scanner) {
        double lado = obtenerDoble(scanner, "Ingrese el lado del cuadrado: ");
        System.out.println("Seleccione la operación:");
        System.out.println("1. Calcular área");
        System.out.println("2. Calcular perímetro");
        int opcionOperacion = obtenerEntero(scanner);
        if (opcionOperacion == 1) {
            return Cuadrado.calcularArea(lado);
        } else {
            return Cuadrado.calcularPerimetro(lado);
        }
    }

    private static double operacionTriangulo(Scanner scanner) {
        double base = obtenerDoble(scanner, "Ingrese la base del triángulo: ");
        double altura = obtenerDoble(scanner, "Ingrese la altura del triángulo: ");
        System.out.println("Seleccione la operación:");
        System.out.println("1. Calcular área");
        System.out.println("2. Calcular perímetro");
        int opcionOperacion = obtenerEntero(scanner);
        if (opcionOperacion == 1) {
            return Triangulo.calcularArea(base, altura);
        } else {
            return Triangulo.calcularPerimetro(base, altura);
        }
    }

    private static double operacionRectangulo(Scanner scanner) {
        double base = obtenerDoble(scanner, "Ingrese la base del rectángulo: ");
        double altura = obtenerDoble(scanner, "Ingrese la altura del rectángulo: ");
        System.out.println("Seleccione la operación:");
        System.out.println("1. Calcular área");
        System.out.println("2. Calcular perímetro");
        int opcionOperacion = obtenerEntero(scanner);
        if (opcionOperacion == 1) {
            return Rectangulo.calcularArea(base, altura);
        } else {
            return Rectangulo.calcularPerimetro(base, altura);
        }
    }

    private static double operacionPentagono(Scanner scanner) {
        double lado = obtenerDoble(scanner, "Ingrese el lado del pentágono: ");
        System.out.println("Seleccione la operación:");
        System.out.println("1. Calcular área");
        System.out.println("2. Calcular perímetro");
        int opcionOperacion = obtenerEntero(scanner);
        if (opcionOperacion == 1) {
            return Pentagono.calcularArea(lado);
        } else {
            return Pentagono.calcularPerimetro(lado);
        }
    }

    private static double operacionPotencia(Scanner scanner) {
        double base = obtenerDoble(scanner, "Ingrese la base: ");
        double exponente = obtenerDoble(scanner, "Ingrese el exponente: ");
        return potencia(base, (int) exponente);
    }

    private static double potencia(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        if (exponente > 0) {
            return base * potencia(base, exponente - 1);
        }
        return 1 / (base * potencia(base, -exponente - 1));
    }
}

class Circulo {
    public static double calcularArea(double radio) {
        return Math.PI * radio * radio;
    }

    public static double calcularPerimetro(double radio) {
        return 2 * Math.PI * radio;
    }
}

class Cuadrado {
    public static double calcularArea(double lado) {
        return lado * lado;
    }

    public static double calcularPerimetro(double lado) {
        return 4 * lado;
    }
}

class Triangulo {
    public static double calcularArea(double base, double altura) {
        return (base * altura) / 2;
    }

    public static double calcularPerimetro(double base, double altura) {
        // No se puede calcular el perímetro con solo la base y la altura
        return -1;
    }
}

class Rectangulo {
    public static double calcularArea(double base, double altura) {
        return base * altura;
    }

    public static double calcularPerimetro(double base, double altura) {
        return 2 * (base + altura);
    }
}

class Pentagono {
    public static double calcularArea(double lado) {
        return (5.0 / 4.0) * Math.pow(lado, 2) / Math.tan(Math.PI / 5);
    }

    public static double calcularPerimetro(double lado) {
        return 5 * lado;
    }
}
