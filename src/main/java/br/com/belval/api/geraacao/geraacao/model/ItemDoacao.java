package br.com.belval.api.geraacao.geraacao.model;

import java.util.Objects;

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
	public ItemDoacao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemDoacao(Integer id, String nome, String descricao, String tamanho, String secao, String tipo,
			String genero, String material, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.secao = secao;
		this.tipo = tipo;
		this.genero = genero;
		this.material = material;
		this.imagem = imagem;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descricao, genero, id, imagem, material, nome, secao, tamanho, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDoacao other = (ItemDoacao) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(genero, other.genero)
				&& Objects.equals(id, other.id) && Objects.equals(imagem, other.imagem)
				&& Objects.equals(material, other.material) && Objects.equals(nome, other.nome)
				&& Objects.equals(secao, other.secao) && Objects.equals(tamanho, other.tamanho)
				&& Objects.equals(tipo, other.tipo);
	}
	@Override
	public String toString() {
		return "ItemDoacao [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", tamanho=" + tamanho
				+ ", secao=" + secao + ", tipo=" + tipo + ", genero=" + genero + ", material=" + material + ", imagem="
				+ imagem + "]";
	}
	
	//getters e setters premitem acessar e modificar os atributos privados 
	
	
}
