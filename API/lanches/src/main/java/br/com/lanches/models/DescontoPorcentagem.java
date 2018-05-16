package br.com.lanches.models;

public class DescontoPorcentagem implements Desconto {

	private double porcentagem;
	
	
	
	public DescontoPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}



	@Override
	public double aplly(double preco) {
		return preco*(1 - porcentagem);
	}

}
