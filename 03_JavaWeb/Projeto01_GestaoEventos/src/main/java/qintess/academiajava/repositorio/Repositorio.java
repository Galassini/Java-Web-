package qintess.academiajava.repositorio;

import qintess.academiajava.classes.dal.ConvidadosDao;
import qintess.academiajava.classes.dal.EventoConvidadosDao;
import qintess.academiajava.classes.dal.EventosDao;
import qintess.academiajava.classes.dal.UsuariosDao;

public class Repositorio {

	private static EventosDao eventosDao;
	private static ConvidadosDao convidadosDao;
	private static EventoConvidadosDao eventoConvidadosDao;
	private static UsuariosDao usuariosDao;
	
	public static UsuariosDao getUsuariosDao() {
		if (usuariosDao == null) {
			usuariosDao = new UsuariosDao();
			
		}
		return usuariosDao;
	}
	
	public static EventosDao getEventosDao() {
		if(eventosDao == null) {
			eventosDao = new EventosDao();
		}
		return eventosDao;
	}
	
	public static ConvidadosDao getConvidadosDao() {
	if(convidadosDao == null) {
		convidadosDao = new ConvidadosDao();
	}
	return convidadosDao;
}
	public static EventoConvidadosDao getEventoConvidadosDao() {
		if(eventoConvidadosDao == null) {
			eventoConvidadosDao = new EventoConvidadosDao();
		}
		return eventoConvidadosDao;
	}
}
