package Paquetecuenta;

import java.util.Scanner;

public class ProgramaCuenta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el ID de la cuenta:");
        String id = sc.nextLine();

        System.out.println("Ingrese el nombre del titular:");
        String name = sc.nextLine();

        System.out.println("Ingrese el saldo inicial:");
        int saldo = sc.nextInt();

        Account cuenta1 = new Account(id, name, saldo);

        System.out.println("Información de la cuenta:");
        System.out.println(cuenta1.toString());

        System.out.println("Ingrese monto a acreditar:");
        int credito = sc.nextInt();
        cuenta1.credit(credito);
        System.out.println("Nuevo saldo: " + cuenta1.getBalance());

        System.out.println("Ingrese monto a debitar:");
        int debito = sc.nextInt();
        cuenta1.debit(debito);
        System.out.println("Saldo tras débito: " + cuenta1.getBalance());


        Account cuenta2 = new Account("C002", "CuentaDestino", 500);
        System.out.println("Transfiriendo $100 a otra cuenta...");
        cuenta1.transferTo(cuenta2, 100);
        System.out.println("Saldo cuenta origen: " + cuenta1.getBalance());
        System.out.println("Saldo cuenta destino: " + cuenta2.getBalance());
    }
}