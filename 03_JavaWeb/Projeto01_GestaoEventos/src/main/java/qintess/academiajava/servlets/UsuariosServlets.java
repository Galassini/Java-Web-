package qintess.academiajava.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qintess.academiajava.classes.models.Usuario;
import qintess.academiajava.repositorio.Repositorio;

@WebServlet(urlPatterns = 
{ 
		"/admin/usuarios",
		"/admin/logoff"
})
public class UsuariosServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UsuariosServlets() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String caminho = request.getServletPath();
		
		try {
			if (caminho.equals("/admin/usuarios")) {
				request.getRequestDispatcher("/WEB-INF/admin/novousuario.jsp")
				.forward(request, response);
			} else if (caminho.equals("/admin/logoff")) {
				HttpSession session = request.getSession();
				//session.removeAttribute("session_usuario");
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
			
		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/erro.jsp")
			.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("txtUsername");
			String password = request.getParameter("txtPassword");
			String confirma = request.getParameter("txtConfirma");
			int nivel = Integer.parseInt(request.getParameter("cmbNivel"));
			
			if (!password.equals(confirma)) {
				throw new IllegalArgumentException("As senhas não coferem.");
			}
			
			Usuario usuario = new Usuario();
			usuario.setUsuario(username);
			usuario.setSenha(password);
			usuario.setNivel(nivel);
			
			Repositorio.getUsuariosDao().incluirUsuario(usuario);
			
			request.setAttribute("mensagem", "O usuário '"+username+"' foi incluído com sucesso");
			request.getRequestDispatcher("/WEB-INF/sucesso.jsp").forward(request, response);
			
			/*request.getRequestDispatcher("/WEB-INF/sucesso.jsp")
			.forward(request, response);*/
		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/erro.jsp")
			.forward(request, response);
		}
	}

}