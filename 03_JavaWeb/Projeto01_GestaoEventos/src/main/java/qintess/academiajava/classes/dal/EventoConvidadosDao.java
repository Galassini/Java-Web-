package qintess.academiajava.classes.dal;

import java.util.ArrayList;
import java.util.Collection;

import qintess.academiajava.classes.viewmodels.EventoConvidadosVM;

public class EventoConvidadosDao extends GenericDao {


	
	public Collection<EventoConvidadosVM> listar() throws Exception {
		Collection<EventoConvidadosVM> lista = new ArrayList<EventoConvidadosVM>();
		
		try {
			abrirConexao();
			StringBuilder sb = new StringBuilder()
					.append("SELECT ")
					.append(" C.NOME AS NOME, ")
					.append(" C.EMAIL AS EMAIL,")
					.append(" E.DESCRICAO AS EVENTO")
					.append(" FROM ")
					.append(" TB_EVENTOS E, TB_CONVIDADOS C")
					.append(" WHERE")
					.append(" E.ID = C.IDEVENTO");
			
			stmt = cn.prepareStatement(sb.toString());
			rs = stmt.executeQuery();
			while(rs.next()){
				EventoConvidadosVM vm = new EventoConvidadosVM();
				vm.setNome(rs.getString("nome"));
				vm.setEmail(rs.getString("email"));
				vm.setEvento(rs.getString("evento"));
				
				lista.add(vm);
				
			}
			/*String sql = "select" 
					+ " c.nome as nome, "
					+ " c.email as email, "
					+ " e.descricao as evento "
					+ " from "
					+ " tb_eventos e, tb_convidados c "
					+ " where "
					+ " e.id = c.idevento;";*/
			
		} catch (Exception e) {
			throw e;
		}finally {
			fecharConexao();
			
		}
		
		return lista;
	}

}
