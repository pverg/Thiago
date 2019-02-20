package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.exception.NotFoundException;
import br.com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {

	private static Logger log = Logger.getLogger(TerminalConsulta.class);
	
	// Camada de apresentação
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		EstoqueBO bo = new EstoqueBO();
		Calendar data = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		String opcao = null;
		
		log.warn("Inicializando a aplicação");
		
		System.out.println("FIAP STORE -------------- " + sdf.format(data.getTime()));
		
		int codigo;
		
		do {
			System.out.println("");
			codigo = 0;
			System.out.print("Digite o código: ");
			codigo = scn.nextInt();
			
			log.trace("Recebendo código");
			log.debug("Tomada de decisão realizada: " + codigo);
			
			try {
				
				ProdutoTO produto = bo.consultarProduto(codigo);
				System.out.println(produto.getDescricao());
				System.out.println("Preço: " + produto.getPreco());
				System.out.println("Qtd: " + produto.getQtd());
			} catch (NotFoundException e) {
				System.err.println("Produto não encontrado!");
				
				log.error("Produto não encontrado");
			}
			
			System.out.print("Pesquisar outro produto (Y - Sim; N - Não)? ");
			opcao = scn.next();
			while (!opcao.equalsIgnoreCase("Y") && !opcao.equalsIgnoreCase("N")) {
				System.out.println("Opção inválida!");
				
				log.error("Opção inválida!");
				
				System.out.print("Pesquisar outro produto (Y - Sim; N - Não)? ");
				opcao = scn.next();
			}
			
		} while (opcao.equalsIgnoreCase("Y"));
		
		log.warn("Finalizando a aplicação");
		
		scn.close();
	}
	
}