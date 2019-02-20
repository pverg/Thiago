package br.com.fiap.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ContaCorrente extends Conta {

	private TipoConta tipo;
	
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}
	
	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	@Override
	public double retirar(double valor) throws Exception {
		if (tipo == TipoConta.COMUM && saldo < valor) {
			throw new Exception("Saldo insuficiente!");
		}
		saldo -= valor;
		return saldo;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		return "Agencia: " + getAgencia() + "\n" + 
				"Número: " + getNumero() + "\n" + 
				"Tipo: " + getNumero() + "\n" + 
				"Saldo: " + getSaldo() + "\n" + 
				"DataAbertura: " + sdf.format(getDataAbertura().getTime()) + "\n";
	}

}
