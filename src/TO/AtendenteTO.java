package TO;

public class AtendenteTO extends LoginTO {

	int idAtendente;
	String nome,cpf;
	
	public AtendenteTO(String senha, String tipo, int id, int idAtendente, String nome, String cpf) {
		super(senha, tipo, id);
		this.idAtendente = idAtendente;
		this.nome = nome;
		this.cpf = cpf;
	}
	public int getIdAtendente() {
		return idAtendente;
	}
	public void setIdAtendente(int idAtendente) {
		this.idAtendente = idAtendente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	

}
