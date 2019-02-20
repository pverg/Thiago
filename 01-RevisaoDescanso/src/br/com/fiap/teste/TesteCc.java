package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class TesteCc {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		
//		ContaCorrente cc1 = new ContaCorrente();
//		ContaCorrente cc2 = new ContaCorrente();
//		ContaCorrente cc3 = new ContaCorrente();
//		
//		System.out.print("Saldo Conta Corrente 1: ");
//		cc1.setSaldo(scn.nextDouble());
//		System.out.print("Saldo Conta Corrente 2: ");
//		cc2.setSaldo(scn.nextDouble());
//		System.out.print("Saldo Conta Corrente 3: ");
//		cc3.setSaldo(scn.nextDouble());
//		
//		System.out.println("");
		
//		cc1.setSaldo(1000);
//		cc2.setSaldo(1500);
//		cc3.setSaldo(2500);
		
		List<ContaCorrente> cc = new ArrayList<>();
		
		cc.add(new ContaCorrente(1,2,new GregorianCalendar(2010,Calendar.APRIL,20),100,TipoConta.COMUM));
		cc.add(new ContaCorrente(1,3,new GregorianCalendar(2015,Calendar.DECEMBER,25),50000,TipoConta.ESPECIAL));
		cc.add(new ContaCorrente(1,4,Calendar.getInstance(),0,TipoConta.PREMIUM));
		
		for (ContaCorrente item : cc) {
			System.out.println(item.toString());
		}
		
	}
	
}
