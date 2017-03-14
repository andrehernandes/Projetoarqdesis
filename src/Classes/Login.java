package Classes;

public class Login {
	String usuario,senha,tipo;
	int id;

	public Login(String usuario, String senha, String tipo, int id) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.tipo = tipo;
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
