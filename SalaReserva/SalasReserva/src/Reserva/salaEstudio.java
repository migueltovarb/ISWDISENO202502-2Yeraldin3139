package Reserva;

public class salaEstudio {
	
	private int numeroSala;
	private int capacidadMaxima;
	private boolean disponibilidad;
	
	public salaEstudio(String string, int i, boolean b) {
		
	}
	
	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "salaEstudio [numeroSala=" + numeroSala + ", capacidadMaxima=" + capacidadMaxima + ", disponibilidad="
				+ disponibilidad + "]";
	}

	public boolean isDisponible() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setDisponible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
