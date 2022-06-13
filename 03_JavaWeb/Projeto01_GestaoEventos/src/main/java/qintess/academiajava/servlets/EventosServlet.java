package qintess.academiajava.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qintess.academiajava.classes.models.Evento;
import qintess.academiajava.repositorio.Repositorio;


@WebServlet(urlPatterns = {
		"/admin/eventos", 
		"/admin/novoevento", 
		"/admin/alterarevento",
		"/admin/excluirevento"     // Necessita de parâmetro na requisição
		})
public class EventosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EventosServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String caminho = request.getServletPath();
		String pagina = "/WEB-INF/admin/";
		
			try {
				
				if (caminho.equals("/admin/eventos")) {
				Collection<Evento> listaEventos = Repositorio.getEventosDao().listar();
				request.setAttribute("listaEventos", listaEventos);
				pagina += "eventos.jsp";
				
				
				}else if (caminho.equals("/admin/novoevento")) {
					pagina += "novoevento.jsp";
				
				
				} else if(caminho.equals("/admin/alterarevento")){
						String param = request.getParameter("idevento");
						
						if (param == null) {
							throw new NullPointerException("O parâmetro da requisiçao é obrigatório");
						}
						Evento evento = Repositorio.getEventosDao().buscar(Integer.parseInt(param));
						request.setAttribute("evento", evento);
						pagina += "alterarevento.jsp";
						
				
				}else if (caminho.equals("/admin/excluirevento")) {
					String param = request.getParameter("idevento");
					if (param == null) {
						throw new NullPointerException("O parâmetro da requisiçao é obrigatório");
					}
					Evento evento = Repositorio.getEventosDao().buscar(Integer.parseInt(param));
					request.setAttribute("evento", evento);
					pagina += "excluirevento.jsp";
				}
			
			} catch (Exception e) {
				request.setAttribute("mensagem", e.getMessage());
				pagina = "/WEB-INF/erro.jsp";
			}finally {
				request.getRequestDispatcher(pagina).forward(request, response);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String caminho = request.getServletPath();
			
			if (!caminho.equals("/admin/excluirevento")) {
			
			//Obtendo os dados do formulario
			String descricao = request.getParameter("txtDescricao");
			String responsavel = request.getParameter("txtResponsavel");
			Date data = new SimpleDateFormat
					("yyyy-MM-dd").parse(request.getParameter("txtData"));
			double preco = Double.parseDouble(request.getParameter("txtPreco"));
			
			
			// Obtendo o caminho do servlet
			
			
			if (caminho.equals("/admin/novoevento")) {
				//Criando o objeto Evento
				Evento evento = new Evento();
				evento.setDescricao(descricao);
				evento.setResponsavel(responsavel);
				evento.setData(data);
				evento.setPreco(preco);
				
				// Incluindo no banco de dados
				Repositorio.getEventosDao().incluir(evento);
			}else if (caminho.equals("/admin/alterarevento")) {
				int id = Integer.parseInt(request.getParameter("txtId"));
				Evento evento = Repositorio.getEventosDao().buscar(id);
				evento.setDescricao(descricao);
				evento.setResponsavel(responsavel);
				evento.setData(data);
				evento.setPreco(preco);
				
				Repositorio.getEventosDao().alterar(evento);
				}
			}else{ 
				int id = Integer.parseInt(request.getParameter("txtId"));
				Repositorio.getEventosDao().excluir(id);
			}
			
			response.sendRedirect("eventos");
			
		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/erro.jsp").forward(request, response);
		}
		
	}

}