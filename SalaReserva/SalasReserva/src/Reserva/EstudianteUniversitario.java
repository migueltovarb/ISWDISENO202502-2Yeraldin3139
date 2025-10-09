package Reserva;

public class EstudianteUniversitario {
	
	private String nombre;
    private int codigoInst;
    private String programaAcademico;
   
    public EstudianteUniversitario(String nombre, String codigoInst, String programaAcademico) {
	   
   }


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigoInst() {
		return codigoInst;
	}

	public void setCodigoInst(int codigoInst) {
		this.codigoInst = codigoInst;
	}

	public String getProgramaAcademico() {
		return programaAcademico;
	}

	public void setProgramaAcademico(String programaAcademico) {
		this.programaAcademico = programaAcademico;
	}

	@Override
	public String toString() {
		return "EstudianteUniversitario [codigoInst=" + codigoInst + "]";
	}

	public Object getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
   


