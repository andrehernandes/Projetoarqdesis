package TO;

public class FuncionarioTO extends LoginTO {
	String nome,cpf,data,horarioEntrada,horarioSaida;
	int idFuncionario;
	
	
	public FuncionarioTO(String senha, String tipo, int id, String nome, String cpf, String data,
			String horarioEntrada, String horarioSaida, int idFuncionario) {
		super(senha, tipo, id);
		this.nome = nome;
		this.cpf = cpf;
		this.data = data;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.idFuncionario = idFuncionario;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public String getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	

	

}
