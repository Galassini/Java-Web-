package qintess.academiajava.classes.dal;

import java.util.Collection;


public abstract class Dao<T> extends GenericDao {

	
	
	public abstract void incluir(T item) throws Exception;
	public abstract T buscar(int pk) throws Exception;
	public abstract Collection<T> listar() throws Exception;
	
	
	
	
}
