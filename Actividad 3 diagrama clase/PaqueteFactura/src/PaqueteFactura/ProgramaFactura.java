package PaqueteFactura;

import java.util.Scanner;

public class ProgramaFactura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el ID del ítem:");
        String id = sc.nextLine();

        System.out.println("Ingrese la descripción:");
        String desc = sc.nextLine();

        System.out.println("Ingrese la cantidad:");
        int qty = sc.nextInt();

        System.out.println("Ingrese el precio unitario:");
        double unitPrice = sc.nextDouble();

        InvoiceItem item = new InvoiceItem(id, desc, qty, unitPrice);

        System.out.println("Información del ítem:");
        System.out.println(item.toString());

        System.out.println("Total a pagar: $" + item.getTotal());

        System.out.println("¿Desea actualizar la cantidad? (s/n)");
        sc.nextLine(); 
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese la nueva cantidad:");
            int nuevaCantidad = sc.nextInt();
            item.setQty(nuevaCantidad);
            System.out.println("Nuevo total: $" + item.getTotal());
        }
    }
}
