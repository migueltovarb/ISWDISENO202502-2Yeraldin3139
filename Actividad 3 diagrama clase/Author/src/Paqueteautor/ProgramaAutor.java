package Paqueteautor;


import java.util.Scanner;

public class ProgramaAutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del autor:");
        String name = sc.nextLine();

        System.out.println("Ingrese el correo electrónico:");
        String email = sc.nextLine();

        System.out.println("Ingrese el género (m/f):");
        char gender = sc.next().charAt(0);

        Author autor = new Author(name, email, gender);

        System.out.println("Información del autor:");
        System.out.println(autor.toString());

        System.out.println("¿Desea actualizar el correo? (s/n)");
        sc.nextLine(); 
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Ingrese el nuevo correo:");
            String nuevoEmail = sc.nextLine();
            autor.setEmail(nuevoEmail);
            System.out.println("Correo actualizado:");
            System.out.println(autor.toString());
        }
    }
}