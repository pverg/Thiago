package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TerminalConsulta {

	public static void main(String[] args) {
		
		int codigo;
		String opcao = null;
		Scanner scn = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.println("FIAP STORE -------------- " + sdf.format(Calendar.getInstance().getTime()));
		System.out.println("");

		
		do {
			codigo = 0;
			System.out.print("Código: ");
			codigo = scn.nextInt();
			
			switch (codigo) {
			case 401:
				System.out.println("Código " + codigo + " - Camiseta Branca");
				break;
			case 402:
				System.out.println("Código " + codigo + " - Camiseta Azul");
				break;
			case 403:
				System.out.println("Código " + codigo + " - Camiseta Rosa");
				break;
			default:
				System.out.println("Produto não encontrado");
			}
			System.out.print("Pesquisar outro produto (Y - Sim; N - Não)? ");
			opcao = scn.next();
			while (!opcao.equalsIgnoreCase("Y") && !opcao.equalsIgnoreCase("N")) {
				System.out.println("Opção inválida!");
				System.out.print("Pesquisar outro produto (Y - Sim; N - Não)? ");
				opcao = scn.next();
			}
			
		} while (opcao.equalsIgnoreCase("Y"));
		
		scn.close();
	}
	
}