package modelo;

public class Persona {

	private String id;
	private String departamento;
	private String usuario;
	private String contra;
	private String tipo;
	private String nombre;
	private String paterno;
	private String materno;	
	private String entrada;
	private String salida;
	private String telefono;
	private String email;
	private String activo;

	public Persona(String id, String departamento, String usuario, String contra, String tipo, String nombre,
			String paterno, String materno, String entrada, String salida, String telefono, String email,
			String activo) {
		super();
		this.id = id;
		this.departamento = departamento;
		this.usuario = usuario;
		this.contra = contra;
		this.tipo = tipo;		
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.entrada = entrada;
		this.salida = salida;
		this.telefono = telefono;
		this.email = email;
		this.activo = activo;
	}

	public Persona() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public void mostrarDatos() {
		System.out.printf("%s %s %s %s %s %s %s %s %s %s %s %s %s %s\n",
				id, departamento, usuario, contra, tipo, nombre, paterno, materno, departamento, entrada, salida, telefono, email, activo);
	}
	
}
