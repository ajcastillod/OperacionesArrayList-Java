import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OperacionArraylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaCompras = new ArrayList<>();
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar un producto a la lista");
            System.out.println("2. Mostrar la lista de compras");
            System.out.println("3. Eliminar un producto de la lista");
            System.out.println("4. Buscar un producto en la lista");
            System.out.println("5. Ordenar la lista de productos alfabéticamente");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            // Manejo de excepciones para la opción del menú
            while (true) {
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    break; // Salir del bucle si la entrada es válida
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                    scanner.next(); // Limpiar el buffer
                }
            }

            switch (opcion) {
                case 1:
                    agregarProducto(listaCompras, scanner);
                    break;
                case 2:
                    mostrarLista(listaCompras);
                    break;
                case 3:
                    eliminarProducto(listaCompras, scanner);
                    break;
                case 4:
                    buscarProducto(listaCompras, scanner);
                    break;
                case 5:
                    ordenarLista(listaCompras);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    // Método para agregar un producto a la lista
    private static void agregarProducto(ArrayList<String> lista, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a agregar: ");
        String producto = scanner.nextLine();
        lista.add(producto);
        System.out.println("Producto agregado: " + producto);
    }

    // Método para mostrar la lista de compras
    private static void mostrarLista(ArrayList<String> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista de compras está vacía.");
        } else {
            System.out.println("Lista de compras:");
            for (String producto : lista) {
                System.out.println("- " + producto);
            }
        }
    }

    // Método para eliminar un producto de la lista
    private static void eliminarProducto(ArrayList<String> lista, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String producto = scanner.nextLine();
        if (lista.remove(producto)) {
            System.out.println("Producto eliminado: " + producto);
        } else {
            System.out.println("El producto no se encontró en la lista.");
        }
    }

    // Método para buscar un producto en la lista
    private static void buscarProducto(ArrayList<String> lista, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String producto = scanner.nextLine();
        if (lista.contains(producto)) {
            System.out.println("El producto " + producto + " está en la lista.");
        } else {
            System.out.println("El producto no se encontró en la lista.");
        }
    }

    // Método para ordenar la lista de productos alfabéticamente
    private static void ordenarLista(ArrayList<String> lista) {
        Collections.sort(lista);
        System.out.println("Lista de productos ordenada alfabéticamente:");
        mostrarLista(lista);
    }
}