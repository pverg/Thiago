package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Pastel;

public class BuscaTeste {

	public static void main(String[] args) {
		
		//Obter uma fábrica de entity manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Obter um entity manager
		EntityManager em = factory.createEntityManager();
		
		//Pesquisar um pastel de id = 1
		Pastel pastel = em.find(Pastel.class, 1);
		
		//Exibir o sabor do pastel
		System.out.println("");
		System.out.println("******************************");
		System.out.println("");
		
		System.out.println("Sabor do pastel: " + pastel.getSabor());
		System.out.println("Preço do pastel: R$" + pastel.getPreco());
		
		System.out.println("");
		System.out.println("******************************");
		System.out.println("");
		
		//Alterar o sabor do pastel
		pastel.setSabor("4 Queijos");
		
		//Fazer um commit
		em.getTransaction().begin();
		em.getTransaction().commit();

		//fechar as paradas
		em.close();
		factory.close();
	}
	
}
