package ServletFuncionarios;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAOFuncionario;
import model.Funcionarios;



@WebServlet("/EditarFuncionariosServlet")
public class EditarFuncionariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String sId = request.getParameter("id");
		
		int id = Integer.parseInt(sId);
		
		DAOFuncionario daoFuncionario = new DAOFuncionario();
		
		Funcionarios f = daoFuncionario.buscarPorId( id );
		
		request.setAttribute("f", f);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/funcionarios/editar.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		String nome = request.getParameter("nome");
		String funcao = request.getParameter("funcao");
		String unidade = request.getParameter("unidade");

		int id = Integer.parseInt(sId);
		
		
		Funcionarios f = new Funcionarios();
		f.setId(id);
		f.setNome(nome);
		f.setFuncao(funcao);
		f.setUnidade(unidade);
		
		
		DAOFuncionario daoFuncionario = new DAOFuncionario();
		
		daoFuncionario.editar( f );
		
		response.sendRedirect(request.getContextPath()+"/ListarFuncionariosServlet");
	}

}
