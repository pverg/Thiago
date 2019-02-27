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
			System.out.print("C�digo: ");
			codigo = scn.nextInt();
			
			switch (codigo) {
			case 401:
				System.out.println("C�digo " + codigo + " - Camiseta Branca");
				break;
			case 402:
				System.out.println("C�digo " + codigo + " - Camiseta Azul");
				break;
			case 403:
				System.out.println("C�digo " + codigo + " - Camiseta Rosa");
				break;
			default:
				System.out.println("Produto n�o encontrado");
			}
			System.out.print("Pesquisar outro produto (Y - Sim; N - N�o)? ");
			opcao = scn.next();
			while (!opcao.equalsIgnoreCase("Y") && !opcao.equalsIgnoreCase("N")) {
				System.out.println("Op��o inv�lida!");
				System.out.print("Pesquisar outro produto (Y - Sim; N - N�o)? ");
				opcao = scn.next();
			}
			
		} while (opcao.equalsIgnoreCase("Y"));
		
		scn.close();
	}
	
}