package TO;

public class LoginTO {
	String senha, tipo;
	int id;

	

	public LoginTO( String senha, String tipo, int id) {
		super();
		this.senha = senha;
		this.tipo = tipo;
		this.id = id;
	}

	public LoginTO() {

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
