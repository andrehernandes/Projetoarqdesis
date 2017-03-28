package Classes;

import java.sql.SQLException;

import DAO.SindicoDAO;
import TO.FuncionarioTO;

public class Funcionario extends Login {
	String nome,cpf,data,horarioEntrada,horarioSaida;
	int idFuncionario;
	
	

	public Funcionario(String senha, String tipo, int id, String nome, String cpf, String data,
			String horarioEntrada, String horarioSaida, int idFuncionario) {
		super(senha, tipo, id);
		this.nome = nome;
		this.cpf = cpf;
		this.data = data;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.idFuncionario = idFuncionario;
	}
	public Funcionario(){
		super("","",0);
	}
	public String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	protected void setCpf(String cpf) {
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

	protected void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public String getHorarioSaida() {
		return horarioSaida;
	}

	protected void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", data=" + data + ", horarioEntrada=" + horarioEntrada
				+ ", horarioSaida=" + horarioSaida + ", idFuncionario=" + idFuncionario + ", senha=" + senha + ", tipo="
				+ tipo + ", id=" + id + "]";
	}
	private void getTO(FuncionarioTO to){
		setNome(to.getNome());
		setCpf(to.getCpf());
		setId(to.getId());
		setData(to.getData());
		setHorarioSaida(to.getHorarioSaida());
		setHorarioEntrada(to.getHorarioEntrada());
		setTipo(to.getTipo());
	}
	
	public void carregar() throws SQLException
	{
		SindicoDAO dao = new SindicoDAO();
		FuncionarioTO to = new FuncionarioTO(senha,  tipo, id,"","","","", "", 0);
		dao.selecionarFuncionario(to);
		getTO(to);
	}
	
}
