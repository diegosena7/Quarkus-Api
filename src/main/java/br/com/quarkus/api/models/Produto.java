package br.com.quarkus.api.models;

import javax.persistence.*;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name="produto")
public class Produto extends PanacheEntity {


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nome;
	private String descricao;
	private Double valor;
	
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

}
