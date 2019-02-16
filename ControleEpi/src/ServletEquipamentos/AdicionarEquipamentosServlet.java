package ServletEquipamentos;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAOEquipamentos;
import model.DAOFuncionario;
import model.Equipamentos;
import model.Funcionarios;

@WebServlet("/AdicionarEquipamentosServlet")
public class AdicionarEquipamentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOFuncionario daoFuncionario = new DAOFuncionario();
		List<Funcionarios> funcionario = daoFuncionario.listar();
		
		request.setAttribute("funcionarios", funcionario);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/equipamentos/adicionar.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sFuncionarioId = request.getParameter("funcionarioId");
		String nome = request.getParameter("nome");
		String sQuantidade = request.getParameter("quantidade");
		String sDataEntrega = request.getParameter("dataEntrega");
		String sDataDevolucao = request.getParameter("dataDevolucao");
		String sAprovacaoCA = request.getParameter("aprovacaoCA");
		
		
		int funcionarioId = Integer.parseInt(sFuncionarioId);
		int quantidade = Integer.parseInt(sQuantidade);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate lde = LocalDate.parse(sDataEntrega, fmt);
		
		LocalDate ldd = LocalDate.parse(sDataDevolucao, fmt);//tem que fazer um if pra que aqui fique eu possa deixar em branco no formulario
		
		int aprovacaoCA = Integer.parseInt(sAprovacaoCA);
		
		
		Equipamentos e = new Equipamentos();
		e.setNome(nome);
		e.setQuantidade(quantidade);
		e.setDataEntrega(lde);
		e.setDataDevolucao(ldd);
		e.setAprovacaoCA(aprovacaoCA);
		
		DAOFuncionario daoFuncionarios = new DAOFuncionario();
		Funcionarios f = daoFuncionarios.buscarPorId(funcionarioId);
		
		e.setFuncionarios(f);
		
		DAOEquipamentos daoEquipamentos = new DAOEquipamentos();
		daoEquipamentos.adicionar(e);
		
		
		response.sendRedirect(request.getContextPath()+"/ListarEquipamentosServlet");
	}

}
