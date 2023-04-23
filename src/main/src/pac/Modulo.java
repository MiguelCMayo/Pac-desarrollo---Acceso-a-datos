package pac;

public class Modulo {
	
	private Long id;
    private String nombre;
    private String codigo;

    public Modulo(String nombre, String codigo) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Insert into modulo, nombre: " + nombre + 
				", codigo: " + codigo;
	}
}
