package ServletFuncionarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOFuncionario;


@WebServlet("/DeletarFuncionariosServlet")
public class DeletarFuncionariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		HttpSession session = request.getSession();
		DAOFuncionario daoFuncionario = new DAOFuncionario();
		
		daoFuncionario.deletar(Integer.parseInt(sId));
		
		session.setAttribute("mensagem", "O nome deve ser informado: ");
		
		
		response.sendRedirect(request.getContextPath()+"/ListarFuncionariosServlet");
	}

}
