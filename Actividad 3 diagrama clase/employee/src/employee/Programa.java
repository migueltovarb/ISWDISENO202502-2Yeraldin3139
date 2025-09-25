package employee;

import java.util.Scanner;

public class Programa {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Ingrese el ID del empleado:");
	        int id = sc.nextInt();
	        sc.nextLine(); 

	        System.out.println("Ingrese el nombre:");
	        String firstName = sc.nextLine();

	        System.out.println("Ingrese el apellido:");
	        String lastName = sc.nextLine();

	        System.out.println("Ingrese el salario mensual:");
	        int salary = sc.nextInt();

	        Employee emp = new Employee(id, firstName, lastName, salary);

	        System.out.println("Información del empleado:");
	        System.out.println(emp.toString());

	        System.out.println("Salario anual: " + emp.getAnnualSalary());

	        System.out.println("Ingrese el porcentaje de aumento:");
	        int percent = sc.nextInt();
	        int nuevoSalario = emp.raiseSalary(percent);

	        System.out.println("Nuevo salario mensual: " + nuevoSalario);
	        System.out.println("Nueva información: " + emp.toString());
	    }
	}

