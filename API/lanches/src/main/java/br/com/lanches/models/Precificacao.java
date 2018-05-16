package br.com.lanches.models;

public class Precificacao<T> {

	private T item;
	private double preco;
	
	public Precificacao(T item, double preco) {
		this.item = item;
		this.preco = preco;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
