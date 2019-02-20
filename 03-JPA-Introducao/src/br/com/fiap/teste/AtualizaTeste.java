package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Massa;
import br.com.fiap.entity.Pastel;

public class AtualizaTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = factory.createEntityManager();
		
		Pastel pastel = new Pastel(2, "Romeu e Julieta", 3, true, Massa.DOCE, 
				new GregorianCalendar(2019,Calendar.JANUARY,10), null);
		
		em.merge(pastel);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
	
}
