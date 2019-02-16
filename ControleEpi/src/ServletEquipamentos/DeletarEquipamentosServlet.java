package ServletEquipamentos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAOEquipamentos;

@WebServlet("/DeletarEquipamentosServlet")
public class DeletarEquipamentosServlet extends HttpServlet {

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		HttpSession session = request.getSession();
		DAOEquipamentos daoEquipamentos = new DAOEquipamentos();
		
		daoEquipamentos.deletar(id);
		
		response.sendRedirect(request.getContextPath()+"/ListarEquipamentosServlet");
	}
}
