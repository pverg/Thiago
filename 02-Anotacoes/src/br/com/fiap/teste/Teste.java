package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.bean.Pessoa;

public class Teste {

	public static void main(String[] args) {
		// Instanciar uma pessoa
		
		Pessoa peter = new Pessoa();
		//API Reflection -> obter o nome da classe
		String nome = peter.getClass().getName();
		System.out.println(nome);
		
		//Obter os métodos da classe
		Method[] methods = peter.getClass().getDeclaredMethods(); // Brings only declared methods on class. Ignores Object class methods
		
		for (Method item : methods) {
			System.out.println(item.getName());
		}
		
//		for (int i=0; i<methods.length; i++) {
//			System.out.println(methods[i].getName());
//		}
		
		// Obter atributos da classe
		System.out.println("Atributos");
		Field[] atributos = peter.getClass().getDeclaredFields();
		
		for (int i=0; i<atributos.length; i++) {
			System.out.println(atributos[i].getName());
			//Recuperar a anotação @Coluna
			Coluna anotacao = atributos[i].getAnnotation(Coluna.class);
			System.out.println("Nome: "+ anotacao.nome());
			System.out.println("Tipo: "+ anotacao.tipo());
			System.out.println("Tamanho: "+ anotacao.tamanho());
		}
	}
		
}
