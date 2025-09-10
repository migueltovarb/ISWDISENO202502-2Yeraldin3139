package InventarioSupermercado;

import java.util.Scanner;

public class InventarioSupermercado {
	static final int MAX_PRODUCTOS=5;
	static final String[] nombres = new String[MAX_PRODUCTOS];
	static final int[] cantidades = new int[MAX_PRODUCTOS];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ingresarNombreProducto(sc);
       
        int opcion;
        do {
            System.out.println("\n--- Menu Inventario ---");
            System.out.println("1. Mostrar todos los productos");
            System.out.println("2. Buscar producto por nombre");
            System.out.println("3. Actualizar inventario");
            System.out.println("4. Mostrar alertas de productos (<10)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
            case 1 -> mostrarTodos();
            case 2 -> buscarProducto(sc);
            case 3 -> actualizarInventario(sc);
            case 4 -> mostrarAlertas();
            case 5 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
	}
    
	static void ingresarNombreProducto(Scanner sc) {
        System.out.println("--- INGRESO DE PRODUCTOS ---");
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            System.out.print("Nombre del producto " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
            System.out.print("Cantidad en inventario: ");
            cantidades[i] = sc.nextInt();
            sc.nextLine();
            }
        }
        
        static void mostrarTodos() {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (int i = 0; i < MAX_PRODUCTOS; i++) {
                System.out.println(nombres[i] + ": " + cantidades[i] + " unidades");
            }
        }  
       
        static void buscarProducto(Scanner sc) {
            sc.nextLine();
            System.out.println("Ingrese el nombre del producto a buscar: ");
            String nombreBuscado = sc.nextLine();
            boolean encontrado = false;

            for (int i = 0; i < MAX_PRODUCTOS; i++) {
                if (nombres[i].equalsIgnoreCase(nombreBuscado)) {
                    System.out.println(nombres[i] + ": " + cantidades[i] + " unidades");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Producto no encontrado.");
            }
        }

        static void actualizarInventario(Scanner sc) {
            System.out.print("Ingrese el nombre del producto a actualizar: ");
            
            String nombreActualizar;
            do {
                nombreActualizar = sc.nextLine().trim();
            } while (nombreActualizar.isEmpty()); 
            boolean encontrado = false;

            for (int i = 0; i < MAX_PRODUCTOS; i++) {
                if (nombres[i].equalsIgnoreCase(nombreActualizar)) {
                    System.out.print("Cantidad nueva para " + nombres[i] + ": ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Por favor ingrese un número válido:");
                        sc.next(); 
                    }
                    cantidades[i] = sc.nextInt();
                    sc.nextLine(); 
                    System.out.println("Inventario actualizado.");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Producto no encontrado.");
            }
        }

        static void mostrarAlertas() {
            System.out.println("\n--- ALERTAS DE BAJO STOCK (<10) ---");
            for (int i = 0; i < MAX_PRODUCTOS; i++) {
                if (cantidades[i] < 10) {
                    System.out.println(": " + nombres[i] + ": " + cantidades[i] + " unidades");
                }
            }
        }
        static void mostrarResumenTotal() {
            int total = 0;
            for (int cantidad : cantidades) {
                total += cantidad;
            }
            System.out.println("\n Total de productos en inventario: " + total + " unidades");
        }
    
     }



