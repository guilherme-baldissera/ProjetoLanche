package br.com.lanches.models;

import java.util.List;

public class PromoLight implements Promocao{

	private static final double DESCONTO = 0.1;

	@Override
	public Desconto calculo(Lanche lanche) {
		List<Ingrediente> ingredientes = lanche.getIngredientes();
		
		boolean temAlface = ingredientes.stream().anyMatch(i -> IngredientesEnum.ALFACE.equals(i.getNome()));
		boolean temBacon = ingredientes.stream().anyMatch(i -> IngredientesEnum.BACON.equals(i.getNome()));
		
		if(temAlface && !temBacon)
			return new DescontoPorcentagem(DESCONTO);
		
		return null;
	}


}
