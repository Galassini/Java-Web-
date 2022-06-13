package qintess.academiajava.classes.dal;

import qintess.academiajava.classes.models.Usuario;
import qintess.academiajava.classes.utils.Utils;

public class UsuariosDao extends GenericDao {
	
	// método para incluir um novo usuário 
	public void incluirUsuario(Usuario usuario) throws Exception {
		try {
			abrirConexao();
			String sql = "INSERT INTO TB_USUARIOS (USUARIO, SENHA, NIVEL)"
					+ "VALUES (?, ?, ?,)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, Utils.verificarMD5(usuario.getSenha()));
			stmt.setInt(3, usuario.getNivel());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();
		}
	}
	//Metodo para validar o usuario
	public Usuario validarUsuario(String nome, String senha) throws Exception {
		Usuario usuario = null;
		try {
			abrirConexao();
			String sql ="SELECT * FROM TB_USUARIOS WHERE USUARIO=? AND SENHA=?";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, Utils.verificarMD5(senha));
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setNivel(rs.getInt("Nivel"));
			}
			
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();
	}
  return usuario;
}
}