package br.com.lanches.models;

import java.util.List;

public class PromoMuitoQueijo implements Promocao {

	private static final long CADA = 3;
	private static final long PAGA = 2;

	
	@Override
	public Desconto calculo(Lanche lanche) {
		List<Ingrediente> ingredientes = lanche.getIngredientes();	
		
		long qtdQueijos = ingredientes.stream().filter(i -> IngredientesEnum.QUEIJO.equals(i.getNome())).count();
		if(qtdQueijos == 0)
			return null;
		
		double precoQueijo = ingredientes.stream().filter(i -> IngredientesEnum.QUEIJO.equals(i.getNome())).mapToDouble(Ingrediente::getValor).findFirst().orElseGet(() -> 0);
		
		
		return new DescontoPorQuantidade(CADA, PAGA, qtdQueijos, precoQueijo);
	}

}
