package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.Command;

@WebServlet("/controller.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doExecute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				Command comando = (Command) Class.forName("command." + request.getParameter("command")).newInstance();
				comando.executa(request, response);
			} catch ( NullPointerException|InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				RequestDispatcher view = null;
				view = request.getRequestDispatcher("loginPage.jsp");
				view.forward(request, response);
			}
			
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doExecute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doExecute(request, response);
	}

}
