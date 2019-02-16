package ServletEquipamentos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOEquipamentos;
import model.Equipamentos;

@WebServlet("/ListarEquipamentosServlet")
public class ListarEquipamentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEquipamentos daoEquipamentos = new DAOEquipamentos();
		List<Equipamentos> equipamentos = daoEquipamentos.listar();
		
		request.setAttribute("equipamentos", equipamentos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/equipamentos/listar.jsp");
		rd.forward(request, response);
		
	}

}
