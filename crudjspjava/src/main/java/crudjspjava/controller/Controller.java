package crudjspjava.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import crudjspjava.dao.FichaDAO;
import crudjspjava.modelo.Ficha;

@WebServlet("/controller")
public class Controller extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if (action == null) {
			action = "index";
		}

		try {
			if (action.equals("index")) {
				index(request, response);
			} else if (action.equals("paginaCadastrar")) {
				paginaCadastrar(request, response);
			} else if (action.equals("cadastrarFicha")) {
				cadastrarFicha(request, response);
			} else if (action.equals("editar")) {
				paginaEditar(request, response);
			} else if (action.equals("editarFicha")) {
				editarFicha(request, response);
			} 
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		} 
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/viewfichas.jsp");
		rd.forward(request, response);
	}
	
	private void paginaCadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/form.jsp");
		rd.forward(request, response);
	}
	
	private void cadastrarFicha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomePaciente = request.getParameter("nomePaciente");
		String numCarteiraPlano = request.getParameter("numCarteiraPlano");
		String planoDeSaude = request.getParameter("planoDeSaude");
		String especialidade = request.getParameter("especialidade");
		
		Ficha novaficha = new Ficha(nomePaciente, numCarteiraPlano, planoDeSaude, especialidade);
		
		int i = FichaDAO.criarFicha(novaficha);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/viewfichas.jsp");
		rd.forward(request, response);
	}
	
	private void paginaEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/formEditar.jsp");
		rd.forward(request, response);
	}
	
private void editarFicha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		String nomePaciente = request.getParameter("nomePaciente");
		String numCarteiraPlano = request.getParameter("numCarteiraPlano");
		String planoDeSaude = request.getParameter("planoDeSaude");
		String especialidade = request.getParameter("especialidade");
		
		Ficha novaficha = new Ficha(nomePaciente, numCarteiraPlano, planoDeSaude, especialidade);
		
		int i = FichaDAO.editarFicha(novaficha, Integer.parseInt(id));
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/viewfichas.jsp");
		rd.forward(request, response);
	}
}
