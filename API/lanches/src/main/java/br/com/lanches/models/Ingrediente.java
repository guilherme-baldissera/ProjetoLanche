package br.com.lanches.models;


public class Ingrediente {
	
	private IngredientesEnum nome;
	private Double valor;
	
	public Ingrediente() {
		
	}
	
	public Ingrediente(IngredientesEnum nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public IngredientesEnum getNome() {
		return nome;
	}
	
	public void setNome(IngredientesEnum nome) {
		this.nome = nome;
	}
}
