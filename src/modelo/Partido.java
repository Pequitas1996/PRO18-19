package modelo;

public class Partido {
	private int id;
	private int jornada;
	private String nombreCortoLocal;
	private int golesLocal;
	private String nombreCortoVisitante;
	private int golesVisitante;
	
	
	public Partido(int id, int jornada, String nombreCortoLocal, int golesLocal, String nombreCortoVisitante,
			int golesVisitante) {
		super();
		this.id = id;
		this.jornada = jornada;
		this.nombreCortoLocal = nombreCortoLocal;
		this.golesLocal = golesLocal;
		this.nombreCortoVisitante = nombreCortoVisitante;
		this.golesVisitante = golesVisitante;
	}


	public Partido() {
		// TODO Auto-generated constructor stub

	}


	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getJornada() {
		return jornada;
	}





	public void setJornada(int jornada) {
		this.jornada = jornada;
	}





	public String getNombreCortoLocal() {
		return nombreCortoLocal;
	}





	public void setNombreCortoLocal(String nombreCortoLocal) {
		this.nombreCortoLocal = nombreCortoLocal;
	}





	public int getGolesLocal() {
		return golesLocal;
	}





	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}





	public String getNombreCortoVisitante() {
		return nombreCortoVisitante;
	}





	public void setNombreCortoVisitante(String nombreCortoVisitante) {
		this.nombreCortoVisitante = nombreCortoVisitante;
	}





	public int getGolesVisitante() {
		return golesVisitante;
	}





	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

}
