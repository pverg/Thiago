package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
@SequenceGenerator(name="motorista",allocationSize=1)
public class Motorista {

	@Id
	@Column(name="nr_carteira")
	@GeneratedValue(generator="motorista",strategy=GenerationType.SEQUENCE)
	private int numero;
	
	@Column(name="nm_motorista",nullable=false,length=150)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento",nullable=true)
	private Calendar nascimento;
	
	@Lob
	@Column(name="fl_carteira")
	private byte[] carteira;
	
	@Column(name="ds_genero",nullable=true)
	private String genero;

	public Motorista() {
		super();
	}

	public Motorista(int numero, String nome, Calendar nascimento, byte[] carteira, String genero) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.nascimento = nascimento;
		this.carteira = carteira;
		this.genero = genero;
	}

	public Motorista(String nome, Calendar nascimento, byte[] carteira, String genero) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.carteira = carteira;
		this.genero = genero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public byte[] getCarteira() {
		return carteira;
	}

	public void setCarteira(byte[] carteira) {
		this.carteira = carteira;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
