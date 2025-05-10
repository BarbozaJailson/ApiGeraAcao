package br.com.belval.api.geraacao.geraacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemDoacao {
 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String descricao;
	private String tamanho;
	private String secao;
	private String tipo;
	private String genero;
	private String material;
	private String imagem;
	
	//getters e setters premitem acessar e modificar os atributos privados 
	
	public Integer getId() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	
	
	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}
	
	
	public String getdescricao() {
		return descricao;
	}
	public void setdescricao( String descricao) {
		this.descricao = descricao;
	}
	
	
	public String gettamanho() {
		return tamanho;
	}
	public void settamanho( String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getsecao() {
		return secao;
	}
	public void setsecao( String secao) {
		this.secao = secao;
	}
	
	public String gettipo() {
		return tipo;
	}
	public void settipo( String tipo) {
		this.tipo = tipo;
	}
	
	public String getgenero() {
		return genero;
	}
	public void setgenero( String genero) {
		this.genero = genero;
	}
	
	public String getmaterial() {
		return material;
	}
	public void setmaterial( String material) {
		this.material = material;
	}
	
	public String getimagem() {
		return imagem;
	}
	public void setimagem( String imagem) {
		this.imagem = imagem;
	}
}
