 package Classes;

import DAO.SindicoDAO;
import TO.AtendenteTO;

public class Sindico extends Atendente{

	
	public Sindico(String usuario, String senha, String tipo,int id, int idAtendente, String nome, String cpf) {
		super(usuario, senha, tipo,id, idAtendente, nome, cpf);
	}
	public Atendente cadastrarAtendente(AtendenteTO to){
		if(to.getTipo().equals("Atendente"))
		{
			SindicoDAO dao = new SindicoDAO();
			dao.cadastrarAtendente(to);
			Atendente a = new Atendente( to.getUsuario(),  to.getSenha(),  to.getTipo(),  to.getId(), to.getIdAtendente(), to.getNome(), to.getCpf()); 
			return a;
		}
		return null;
	}

}
