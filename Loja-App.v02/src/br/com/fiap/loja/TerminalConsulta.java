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
	
	// Camada de apresenta��o
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		EstoqueBO bo = new EstoqueBO();
		Calendar data = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		String opcao = null;
		
		log.warn("Inicializando a aplica��o");
		
		System.out.println("FIAP STORE -------------- " + sdf.format(data.getTime()));
		
		int codigo;
		
		do {
			System.out.println("");
			codigo = 0;
			System.out.print("Digite o c�digo: ");
			codigo = scn.nextInt();
			
			log.trace("Recebendo c�digo");
			log.debug("Tomada de decis�o realizada: " + codigo);
			
			try {
				
				ProdutoTO produto = bo.consultarProduto(codigo);
				System.out.println(produto.getDescricao());
				System.out.println("Pre�o: " + produto.getPreco());
				System.out.println("Qtd: " + produto.getQtd());
			} catch (NotFoundException e) {
				System.err.println("Produto n�o encontrado!");
				
				log.error("Produto n�o encontrado");
			}
			
			System.out.print("Pesquisar outro produto (Y - Sim; N - N�o)? ");
			opcao = scn.next();
			while (!opcao.equalsIgnoreCase("Y") && !opcao.equalsIgnoreCase("N")) {
				System.out.println("Op��o inv�lida!");
				
				log.error("Op��o inv�lida!");
				
				System.out.print("Pesquisar outro produto (Y - Sim; N - N�o)? ");
				opcao = scn.next();
			}
			
		} while (opcao.equalsIgnoreCase("Y"));
		
		log.warn("Finalizando a aplica��o");
		
		scn.close();
	}
	
}