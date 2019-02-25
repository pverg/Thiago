package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.impl.FarmaciaDAOImpl;
import br.com.fiap.entity.Farmacia;
import br.com.fiap.entity.TipoFarmacia;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;

public class Teste {

	public static void main(String[] args) {
		
		//Instanciar a galera
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = factory.createEntityManager();
		
		FarmaciaDAOImpl dao = new FarmaciaDAOImpl(em);
		
		//Cadastrar uma farmácia
		Farmacia farmacia = 
				new Farmacia("CVS", new GregorianCalendar(2018,Calendar.JANUARY,10), TipoFarmacia.COMUM, true);
		
		try {
			dao.cadastrar(farmacia);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		//Atualizar
		farmacia.setNome("Walgreens");
		
		try {
			dao.atualizar(farmacia);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Pesquisar farmácia de código 1
		Farmacia busca = dao.buscar(1);
		System.out.println(busca.getNome());
		
		//Remover farmácia de código 1
		try {
			dao.deletar(1);
			dao.commit();
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		factory.close();
	}
	
}
