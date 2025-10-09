package Reserva;


import java.util.*;

public class Sistema {
	    public static void main(String[] args) {
	        List<salaEstudio> salas = new ArrayList<>();
	        List<EstudianteUniversitario> estudiantes = new ArrayList<>();
	        List<Reserva> reservas = new ArrayList<>();

	        salas.add(new salaEstudio("Sala A", 6, true));
	        salas.add(new salaEstudio("Sala B", 4, true));

	        Scanner scanner = new Scanner(System.in);
	        int opcion;

	        do {
	            System.out.println("\n--- Sistema de Reserva de Salas ---");
	            System.out.println("1. Mostrar salas disponibles");
	            System.out.println("2. Registrar nuevo estudiante");
	            System.out.println("3. Reservar sala");
	            System.out.println("4. Consultar historial de reservas");
	            System.out.println("5. Salir");
	            System.out.print("Seleccione una opción: ");
	            opcion = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcion) {
	                case 1:
	                    for (salaEstudio sala : salas) {
	                        if (sala.isDisponible()) {
	                            System.out.println(sala);
	                        }
	                    }
	                    break;

	                case 2:
	                    System.out.print("Nombre del estudiante: ");
	                    String nombreEst = scanner.nextLine();
	                    System.out.print("Código institucional: ");
	                    String codigoEst = scanner.nextLine();
	                    System.out.print("Programa académico: ");
	                    String programa = scanner.nextLine();

	                    if (nombreEst.isEmpty() || codigoEst.isEmpty() || programa.isEmpty()) {
	                        System.out.println("No se permiten campos vacíos.");
	                        break;
	                    }

	                    if (buscarEstudiante(estudiantes, codigoEst) != null) {
	                        System.out.println("Ya existe un estudiante con ese código.");
	                        break;
	                    }

	                    estudiantes.add(new EstudianteUniversitario(nombreEst, codigoEst, programa));
	                    System.out.println("Estudiante registrado con éxito.");
	                    break;

	                case 3:
	                    System.out.print("Código del estudiante: ");
	                    String codigo = scanner.nextLine();
	                    EstudianteUniversitario est = buscarEstudiante(estudiantes, codigo);

	                    if (est == null) {
	                        System.out.println("Estudiante no registrado.");
	                        break;
	                    }

	                    System.out.print("Nombre de la sala: ");
	                    String nombreSala = scanner.nextLine();
	                    salaEstudio sala = buscarSala(salas, nombreSala);

	                    if (sala == null || !sala.isDisponible()) {
	                        System.out.println("Sala no disponible.");
	                        break;
	                    }

	                    System.out.print("Fecha (YYYY-MM-DD): ");
	                    String fecha = scanner.nextLine();
	                    System.out.print("Hora (HH:mm): ");
	                    String hora = scanner.nextLine();

	                    if (fecha.isEmpty() || hora.isEmpty()) {
	                        System.out.println("No se permiten campos vacíos.");
	                        break;
	                    }

	                    if (reservaDuplicada(reservas, est, sala, fecha, hora)) {
	                        System.out.println("Ya existe una reserva igual.");
	                        break;
	                    }

	                    reservas.add(new Reserva(est, sala, fecha, hora));
	                    sala.setDisponible(false);
	                    System.out.println("Reserva realizada con éxito.");
	                    break;

	                case 4:
	                    System.out.print("Código del estudiante: ");
	                    String cod = scanner.nextLine();
	                    for (Reserva r : reservas) {
	                        if (r.getEstudiante().getCodigo().equals(cod)) {
	                            System.out.println(r);
	                        }
	                    }
	                    break;

	                case 5:
	                    System.out.println("Gracias por usar el sistema.");
	                    break;

	                default:
	                    System.out.println("Opción inválida.");
	            }

	        } while (opcion != 5);
	    }

	    public static EstudianteUniversitario buscarEstudiante(List<EstudianteUniversitario> lista, String codigo) {
	        for (EstudianteUniversitario e : lista) {
	            if (e.getCodigo().equals(codigo)) return e;
	        }
	        return null;
	    }

	    public static salaEstudio buscarSala(List<salaEstudio> lista, String nombre) {
	        for (salaEstudio s : lista) {
	            if (s.getNombre().equalsIgnoreCase(nombre)) return s;
	        }
	        return null;
	    }

	    public static boolean reservaDuplicada(List<Reserva> lista, EstudianteUniversitario est, salaEstudio sala, String fecha, String hora) {
	        for (Reserva r : lista) {
	            if (r.getEstudiante().equals(est) &&
	                r.getSala().equals(sala) &&
	                r.getFecha().equals(fecha) &&
	                r.getHora().equals(hora)) {
	                return true;
	            }
	        }
	        return false;
	    }
	}