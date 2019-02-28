package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularNotaExame;
import br.com.fiap.bo.DisciplinaBOStub.CalcularNotaExameResponse;

public class ConsoleView2 {

	public static void main(String[] args) {

		//Nota exame
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Média: ");
		float media = scn.nextFloat();
		
		try {
		
			DisciplinaBOStub stub = new DisciplinaBOStub();
			
			CalcularNotaExame exame = new CalcularNotaExame();
			exame.setMedia(media);
			
			CalcularNotaExameResponse resp = stub.calcularNotaExame(exame);
			
			double notaExame = resp.get_return();
			System.out.println("Nota pra tirar no exame é: " + notaExame);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scn.close();
		
	}
	
}
