package Classes;

import java.sql.SQLException;

import DAO.SindicoDAO;
import TO.AtendenteTO;
import TO.EmpresaTO;
import TO.FuncionarioTO;

public class Atendente extends Login {
	int idAtendente;
	String nome,cpf;
	
	
	public Atendente(String senha, String tipo, int id, int idAtendente, String nome, String cpf) {
		super(senha, tipo, id);
		this.idAtendente = idAtendente;
		this.nome = nome;
		this.cpf = cpf;
	}
	public Atendente(){
		super("","",0);
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


	public Funcionario cadastrarFuncionario(FuncionarioTO to) throws Exception
	{
		if(to.getTipo().equals("Funcionario"))
		{
			SindicoDAO dao = new SindicoDAO();
			dao.cadastrarFuncionario(to);
			Funcionario f = new Funcionario(to.getSenha(),  to.getTipo(), to.getId(), to.getNome(), to.getCpf(), to.getData(), to.getHorarioEntrada(), to.getHorarioSaida(), to.getIdFuncionario());
			getTOFuncionario(to, f);
			salvarFuncionarioTxt(f);
			return f;
		}
		return null;
	}
	
	public Empresa cadastrarEmpresa(EmpresaTO to)
	{
		if(to.getTipo().equals("Empresa")){
			SindicoDAO dao = new SindicoDAO();
			dao.cadastrarEmpresa(to);
			Empresa e = new Empresa( to.getSenha(),  to.getTipo(),to.getId(), to.getCnpj(), to.getRazaoSocial(), to.getHorarioFuncionamento(), to.getTempMax(), to.getTempPadrao(),to.getConjunto());
			getTOEmpresa(to, e);
			return e;
		}
		return null;
	}
	
	public void carregar() throws SQLException {
		SindicoDAO dao = new SindicoDAO();
		AtendenteTO a = new AtendenteTO(senha,tipo,id,idAtendente,nome,cpf);
		dao.selecionarAtendente(a);
		getTO(a);
	}

	private void getTOEmpresa(EmpresaTO to, Empresa e) {
		e.setCnpj(to.getCnpj());
		e.setConjunto(to.getConjunto());
		e.setHorarioFuncionamento(to.getHorarioFuncionamento());
		e.setRazaoSocial(to.getRazaoSocial());
		e.setSenha(to.getSenha());
		e.setTempMax(to.getTempMax());
		e.setTempPadrao(to.getTempPadrao());
		e.setTipo(to.getTipo());
	}


	private void getTOFuncionario(FuncionarioTO to, Funcionario f) {
		f.setCpf(to.getCpf());
		f.setData(to.getData());
		f.setHorarioEntrada(to.getHorarioEntrada());
		f.setHorarioSaida(to.getHorarioSaida());
		f.setIdFuncionario(to.getIdFuncionario());
		f.setNome(to.getNome());
		f.setSenha(to.getSenha());
		f.setTipo(to.getTipo());
	}
	protected void getTO(AtendenteTO to){
		setCpf(to.getCpf());
		setIdAtendente(to.getIdAtendente());
		setNome(to.getNome());
		setSenha(to.getSenha());
		setTipo(to.getTipo());
		setId(to.getId());
	}
	@Override
	public String toString() {
		return "Atendente [idAtendente=" + idAtendente + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", tipo=" + tipo + ", id=" + id + "]";
	}
}
