package br.com.fiap.view;

import java.util.Scanner;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CServico;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class CorreioView {

	public static void main(String[] args) {
		//Calcular o prazo de entrega:
		
		//SEDEX 40010
		
		//Ler dois CEPs
		
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Informe o CEP de origem: ");
		String cepOr = scn.next();
		System.out.print("Informe o CEP de destino: ");
		String cepDest = scn.next();
		
		try {
			
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			
			CalcPrazo calculo = new CalcPrazo();
			
			calculo.setNCdServico("40010");
			calculo.setSCepOrigem(cepOr);
			calculo.setSCepDestino(cepDest);
			
			CalcPrazoResponse resp = stub.calcPrazo(calculo);
			
			CServico[] servico = resp.getCalcPrazoResult().getServicos().getCServico();
			System.out.println("Prazo de entrega: " + servico[0].getPrazoEntrega());
			System.out.println("Data de entrega: " + servico[0].getDataMaxEntrega());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		scn.close();
		
	}
	
}
