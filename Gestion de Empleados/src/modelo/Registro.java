package modelo;

public class Registro {
	
	String id;
	String persona;
	String entrada;
	String salida;
	
	public Registro() {
	}

	public Registro(String id, String persona, String entrada, String salida) {
		this.id = id;
		this.persona = persona;
		this.entrada = entrada;
		this.salida = salida;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

}
