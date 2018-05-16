package br.com.lanches.models;

import java.util.List;

public class Pedido {

	List<LanchePedidos> lanchesPedidos;

	public Pedido() {
	}

	public List<LanchePedidos> getLanchesPedidos() {
		return lanchesPedidos;
	}

	public void setLanchesPedidos(List<LanchePedidos> lanchesPedidos) {
		this.lanchesPedidos = lanchesPedidos;
	}
	
	
}
