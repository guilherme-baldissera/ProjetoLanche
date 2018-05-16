package br.com.lanches.models;

import java.util.List;

public class PromoMuitaCarne implements Promocao {

	private static final long CADA = 3;
	private static final long PAGA = 2;

	
	@Override
	public Desconto calculo(Lanche lanche) {
		List<Ingrediente> ingredientes = lanche.getIngredientes();	
		
		long qtdHamburger = ingredientes.stream().filter(i -> IngredientesEnum.HAMBURGUER.equals(i.getNome())).count();
		if(qtdHamburger == 0)
			return null;
		
		double precoHamburguer = ingredientes.stream().filter(i -> IngredientesEnum.HAMBURGUER.equals(i.getNome())).mapToDouble(Ingrediente::getValor).findFirst().orElseGet(() -> 0);
		
		
		return new DescontoPorQuantidade(CADA, PAGA, qtdHamburger, precoHamburguer);
	}

}
