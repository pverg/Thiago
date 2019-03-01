package br.com.fiap.dao;

public interface GenericDAO<T,K> {

	void cadastrar(T identidade);
	
	void alterar(T entidade);
	
	T buscar(K codigo);
	
	void remover(K codigo);
	
	void commit();
	
}
