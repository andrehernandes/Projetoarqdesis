package TO;

public class EmpresaTO extends LoginTO {

	String cnpj,razaoSocial,horarioFuncionamento;
	int tempMax,tempPadrao,conjunto;
	
	

	public EmpresaTO(String usuario, String senha, String tipo, int id, String cnpj, String razaoSocial,
			String horarioFuncionamento, int tempMax, int tempPadrao, int conjunto) {
		super(usuario, senha, tipo, id);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.horarioFuncionamento = horarioFuncionamento;
		this.tempMax = tempMax;
		this.tempPadrao = tempPadrao;
		this.conjunto = conjunto;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public int getConjunto() {
		return conjunto;
	}

	public void setConjunto(int conjunto) {
		this.conjunto = conjunto;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public int getTempMax() {
		return tempMax;
	}

	public void setTempMax(int tempMax) {
		this.tempMax = tempMax;
	}

	public int getTempPadrao() {
		return tempPadrao;
	}

	public void setTempPadrao(int tempPadrao) {
		this.tempPadrao = tempPadrao;
	}
	

}
