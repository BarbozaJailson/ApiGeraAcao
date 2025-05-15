package br.com.belval.api.geraacao.geraacao.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome_instituicao;
	private long cnpj;
	private String nome_doador;
	private long cpf;
	private String nome_item;
	private String tamanho;
	private String genero;
	private String tipo;
	private LocalDate data_cadastro;
	private int quantidade;
	private String staus;
	
	public Doacao() {
		
	}

	public Doacao(Integer id, String nome_instituicao, long cnpj, String nome_doador, long cpf, String nome_item,
			String tamanho, String genero, String tipo, LocalDate data_cadastro, int quantidade, String staus) {
		super();
		this.id = id;
		this.nome_instituicao = nome_instituicao;
		this.cnpj = cnpj;
		this.nome_doador = nome_doador;
		this.cpf = cpf;
		this.nome_item = nome_item;
		this.tamanho = tamanho;
		this.genero = genero;
		this.tipo = tipo;
		this.data_cadastro = data_cadastro;
		this.quantidade = quantidade;
		this.staus = staus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_instituicao() {
		return nome_instituicao;
	}

	public void setNome_instituicao(String nome_instituicao) {
		this.nome_instituicao = nome_instituicao;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome_doador() {
		return nome_doador;
	}

	public void setNome_doador(String nome_doador) {
		this.nome_doador = nome_doador;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome_item() {
		return nome_item;
	}

	public void setNome_item(String nome_item) {
		this.nome_item = nome_item;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDate data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getStaus() {
		return staus;
	}

	public void setStaus(String staus) {
		this.staus = staus;
	}
	
	
}

