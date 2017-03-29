package command;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Classes.Sindico;
import TO.FuncionarioTO;

public class CadastrarFuncionario implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pCpf = request.getParameter("cpf");
		String pHorEntrada = request.getParameter("horEntrada");
		String pHorSaida = request.getParameter("horSaida");
		Date date = new Date();
		FuncionarioTO to = new FuncionarioTO("", "Funcionario", 0, pNome, pCpf, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date),
				pHorEntrada, pHorSaida, 0);
		HttpSession session = request.getSession();
		Sindico s =  (Sindico)session.getAttribute("sindico");
		try {
			s.cadastrarFuncionario(to);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("infoSindico.jsp");
		view.forward(request,response);

	}

}
