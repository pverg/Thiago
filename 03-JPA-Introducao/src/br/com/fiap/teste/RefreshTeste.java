package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Pastel;

public class RefreshTeste {

	public static void main(String[] args) {

		//Atualiza o objeto com os valores do banco
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = factory.createEntityManager();
		
		// Pesquisar o pastel de código 1
		Pastel pastel = em.find(Pastel.class, 1);
		
		// Exibir o sabor
		System.out.println("");
		System.out.println("******************************");
		System.out.println("");
		
		System.out.println("Sabor do pastel: " + pastel.getSabor());
		
		System.out.println("");
		System.out.println("******************************");
		System.out.println("");
		
		// Modificar o sabor no java e exibir
		pastel.setSabor("Pizza");
		
		System.out.println("");
		System.out.println("******************************");
		System.out.println("");
		
		System.out.println("Novo sabor: " + pastel.getSabor());
		
		System.out.println("");
		System.out.println("******************************");
		System.out.println("");
		
		// Faz o refresh
		em.refresh(pastel);
		
		// Exibe novamente o sabor
		System.out.println("");
		System.out.println("******************************");
		System.out.println("");
		
		System.out.println("Novo sabor novamente: " + pastel.getSabor());
		
		System.out.println("");
		System.out.println("******************************");
		System.out.println("");
		
		em.close();
		factory.close();
	}
	
}
