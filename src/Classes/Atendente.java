package Classes;

import DAO.SindicoDAO;
import TO.EmpresaTO;
import TO.FuncionarioTO;

public class Atendente extends Login {
	int idAtendente;
	String nome,cpf;
	
	
	public Atendente(String usuario, String senha, String tipo, int id, int idAtendente, String nome, String cpf) {
		super(usuario, senha, tipo, id);
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


	public Funcionario cadastrarFuncionario(FuncionarioTO to)
	{
		if(to.getTipo().equals("Funcionario"))
		{
			SindicoDAO dao = new SindicoDAO();
			dao.cadastrarFuncionario(to);
			Funcionario f = new Funcionario(to.getUsuario(),  to.getSenha(),  to.getTipo(), to.getId(), to.getNome(), to.getCpf(), to.getData(), to.getHorarioEntrada(), to.getHorarioSaida(), to.getIdFuncionario());
			//getTOFuncionario(to, f);
			return f;
		}
		return null;
	}
	
	public Empresa cadastrarEmpresa(EmpresaTO to)
	{
		if(to.getTipo().equals("Empresa")){
			SindicoDAO dao = new SindicoDAO();
			dao.cadastrarEmpresa(to);
			Empresa e = new Empresa(to.getUsuario(),  to.getSenha(),  to.getTipo(),to.getId(), to.getCnpj(), to.getRazaoSocial(), to.getHorarioFuncionamento(), to.getTempMax(), to.getTempPadrao(),to.getConjunto());
			//getTOEmpresa(to, e);
			return e;
		}
		return null;
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
		e.setUsuario(to.getUsuario());
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
		f.setUsuario(to.getTipo());
	}

}
