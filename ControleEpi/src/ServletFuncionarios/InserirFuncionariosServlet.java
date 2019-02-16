package ServletFuncionarios;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOFuncionario;
import model.Funcionarios;

@WebServlet("/InserirFuncionariosServlet")
public class InserirFuncionariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/pages/funcionarios/inserir.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String funcao = request.getParameter("funcao");
		String unidade = request.getParameter("unidade");

		HttpSession session = request.getSession();

		boolean valido = true;

		if (nome == null || nome.isEmpty()) {
			session.setAttribute("mensagem", "Nome do funcionario");
			valido = false;
		}

		if (valido) {
			Funcionarios f = new Funcionarios();
			f.setNome(nome);
			f.setFuncao(funcao);
			f.setUnidade(unidade);

			DAOFuncionario daoFuncionario = new DAOFuncionario();
			daoFuncionario.inserir(f);

			session.setAttribute("mensagem", "Funcionário foi salvo");
			response.sendRedirect(request.getContextPath() + "/ListarFuncionariosServlet");

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/pages/funcionarios/inserir.jsp");
		}
	}

}
