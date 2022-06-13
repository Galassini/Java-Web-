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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.sendRedirect("login.jsp");  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("txtNome");
			String senha = request.getParameter("txtSenha");

			Usuario usuario = Repositorio.getUsuariosDao().validarUsuario(nome, senha);
			if (usuario == null) {
				throw new Exception("Usuario ou senha invalidos");
				
			}
			//Armazena o objeto Usuario em uma sessão
			HttpSession session = request.getSession();
			session.setAttribute("session_usuario", usuario);
			
			response.sendRedirect("admin/home");

		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/erro.jsp").forward(request, response);
		}
	}

}
