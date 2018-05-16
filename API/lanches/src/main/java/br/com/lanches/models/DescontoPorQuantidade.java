package br.com.lanches.models;

public class DescontoPorQuantidade implements Desconto {
	
	
	private long cada;
	private long paga;
	private long qtdComprada;
	private double precoUnit;
	
	
	public DescontoPorQuantidade(long cada, long paga, long qtdComprada, double precoUnit) {
		this.cada = cada;
		this.paga = paga;
		this.qtdComprada = qtdComprada;
		this.precoUnit = precoUnit;
	}
	

	@Override
	public double aplly(double preco) {
		long qtretirada = (qtdComprada/cada) * (cada-paga);
		double precoDescontado = qtretirada * precoUnit;
		return preco - precoDescontado;
	}

}
