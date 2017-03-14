package TO;

public class LoginTO {
	String usuario, senha, tipo;
	int id;

	

	public LoginTO(String usuario, String senha, String tipo, int id) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
		this.id = id;
	}

	public LoginTO() {

	}

	public String getUsuario() {
		return usuario;
	}

	protected void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	protected void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
