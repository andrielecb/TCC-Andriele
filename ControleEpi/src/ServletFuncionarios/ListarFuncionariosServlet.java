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
@WebServlet("/ListarFuncionariosServlet")
public class ListarFuncionariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOFuncionario dao = new DAOFuncionario();
		List<Funcionarios> funcionarios = dao.listar();
		
		request.setAttribute("funcionarios", funcionarios);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/funcionarios/listar.jsp");
		
		rd.forward(request, response);
	}

}
