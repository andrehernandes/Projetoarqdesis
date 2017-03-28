package command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Classes.Atendente;
import Classes.Funcionario;
import Classes.Login;
import Classes.Sindico;

public class Logar implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) {
		String pSenha = request.getParameter("senha");
		Login login = new Login(pSenha,"",0);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		try {
			if(login.confereSenha(login))
			{
				String tipo = login.getTipo();
				
				switch(tipo)
				{
					case "Sindico":
						Sindico sindico = new Sindico( login.getSenha(),  login.getTipo(), login.getId(),  0,  "",  "");
						sindico.carregar();
						session.setAttribute("sindico", sindico);
						view = request.getRequestDispatcher("infoSindico.jsp");
						view.forward(request,response);
						break;
					case "Atendente":
						Atendente a = new Atendente( login.getSenha(),  login.getTipo(), login.getId(),  0,  "",  "");
						a.carregar();
						session.setAttribute("atendente", a);
						view = request.getRequestDispatcher("infoAtendente.jsp");
						view.forward(request,response);
						break;
					case "Funcionario":
						Funcionario f = new Funcionario(login.getSenha(),  login.getTipo(), login.getId(),"","","","", "", 0);
						f.carregar();
						session.setAttribute("funcionario", f);
						view = request.getRequestDispatcher("infoFuncionario.jsp");
						view.forward(request,response);
						break;
				}
			}
			else{
				view = request.getRequestDispatcher("loginPage.jsp");
				view.forward(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
