package Reserva;

public class Reserva {
    private int fecha;
	private int hora;
	private int salaReservada;
	private String estudianteUniversitario;
	
	
	public Reserva(EstudianteUniversitario est, salaEstudio salaReservada, String fecha, String hora) {
		
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getSalaReservada() {
		return salaReservada;
	}

	public void setSalaReservada(int salaReservada) {
		this.salaReservada = salaReservada;
	}

	public String getEstudianteUniversitario() {
		return estudianteUniversitario;
	}

	public void setEstudianteUniversitario(String estudianteUniversitario) {
		this.estudianteUniversitario = estudianteUniversitario;
	}

	@Override
	public String toString() {
		return "Reserva [fecha=" + fecha + ", hora=" + hora + ", salaReservada=" + salaReservada + "]";
	}

	public EstudianteUniversitario getEstudiante() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSala() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
