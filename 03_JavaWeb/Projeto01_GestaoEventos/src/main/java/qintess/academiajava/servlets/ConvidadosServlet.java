package qintess.academiajava.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qintess.academiajava.classes.models.Convidado;
import qintess.academiajava.classes.models.Evento;
import qintess.academiajava.repositorio.Repositorio;

@WebServlet(urlPatterns = {"/admin/convidados", "/admin/novoconvidado"})

public class ConvidadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConvidadosServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String caminho = request.getServletPath();
			
			// A lista de eventos serve para as duas operações
			
			Collection<Evento> listarEventos = Repositorio.getEventosDao().listar();
			request.setAttribute("eventos", listarEventos);

			if (caminho.equals("/admin/convidados")) {
				String codigo = request.getParameter("codevento");
				Collection<Convidado> listaConvidados;

				if (codigo != null && !codigo.equals("") && !codigo.equals("0")) {

					int idevento = Integer.parseInt(codigo);
					request.setAttribute("codigo", Integer.parseInt(codigo));
					listaConvidados = Repositorio.getConvidadosDao().listar(idevento);
				} else {
					request.setAttribute("codigo", 0);
					listaConvidados = Repositorio.getConvidadosDao().listar();
				}
				request.setAttribute("convidados", listaConvidados);
				request.getRequestDispatcher("/WEB-INF/admin/convidados.jsp")
				.forward(request, response);

			} else if (caminho.equals("/admin/novoconvidado")) {
				request.getRequestDispatcher("/WEB-INF/admin/novoconvidado.jsp")
				.forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/erro.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String caminho = request.getServletPath();
			if(caminho.equals("admin/novocaminho")) {
				
				int idEvento = Integer.parseInt(request.getParameter("cmbEvento"));
				Evento evento = Repositorio.getEventosDao().buscar(idEvento);
				
				String nome =  request.getParameter("txtNome");
				int idade = Integer.parseInt(request.getParameter("txtidade"));
				String email = request.getParameter("txtEmail");
				
				Convidado convidado = new Convidado();
				convidado.setEvento(evento);
				convidado.setNome(nome);
				convidado.setIdade(idade);
				convidado.setEmail(email);
				
				Repositorio.getConvidadosDao().incluir(convidado);
				response.sendRedirect("convidado?codevento" + idEvento);
				
			}
			
		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/erro.jsp").forward(request, response);
		}
	
	}
}
