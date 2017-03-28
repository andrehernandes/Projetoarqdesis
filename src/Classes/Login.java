package Classes;

import java.io.IOException;
import java.text.ParseException;

import Catraca.Txt;

public class Login {
	String senha,tipo;
	int id;

	public Login(String senha, String tipo, int id) {
		super();
		this.senha = senha;
		this.tipo = tipo;
		this.id = id;
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

	protected void salvarAtendenteTxt(Atendente a) throws Exception {
		Login login = new Login(a.getSenha(),a.getTipo(),a.getId());
		Txt.salvarPessoa( login, "BR");
	}
	protected void salvarFuncionarioTxt(Funcionario f) throws Exception {
		Login login = new Login(f.getSenha(),f.getTipo(),f.getId());
		Txt.salvarPessoa( login, "BR");
	}
	protected void salvarEmpresaTxt(Empresa empresa) throws IOException, ParseException {
		Txt.salvarEmpresa( empresa, "BR");
	}
	
	public boolean confereSenha(Login login) throws IOException, Exception{
		return Txt.confereSenha(login);
	}
	
	
	public static void main(String args[]) throws IOException, ParseException
	{
		Empresa e = new Empresa("asdasd", "asdas", 2, "dasda", "asdasd", "18:00 02/12/2016", 22132, 2165465, 5465454);
		Login l = new Login(e.getSenha(),e.getTipo(),e.getId());
		l.salvarEmpresaTxt(e);
	}
}
