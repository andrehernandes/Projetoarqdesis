package Classes;

import DAO.SindicoDAO;
import TO.AtendenteTO;
import TO.FuncionarioTO;

public class Sindico extends Atendente {

	public Sindico(String senha, String tipo, int id, int idAtendente, String nome, String cpf) {
		super(senha, tipo, id, idAtendente, nome, cpf);
	}
	public Sindico(){
		super();
	}
	public Atendente cadastrarAtendente(AtendenteTO to) throws Exception {
		if (to.getTipo().equals("Atendente")) {
			SindicoDAO dao = new SindicoDAO();
			dao.cadastrarAtendente(to);
			Atendente a = new Atendente(to.getSenha(), to.getTipo(), to.getId(), to.getIdAtendente(), to.getNome(),
					to.getCpf());
			salvarAtendenteTxt(a);
			return a;
		}
		return null;
	}
	@Override
	public String toString() {
		return "Sindico [idAtendente=" + idAtendente + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha
				+ ", tipo=" + tipo + ", id=" + id + "]";
	}
	
	
	
	
	
	

}
