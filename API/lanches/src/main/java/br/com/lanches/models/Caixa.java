package br.com.lanches.models;

import java.util.List;
import java.util.stream.Collectors;

public class Caixa {
	
	
	public Precificacao<List<Lanche>> trazAConta(List<Lanche> lanches){
		double precoTotal = getLanchesPrecos(lanches)
				.stream()
				.mapToDouble(Precificacao::getPreco)
				.sum();
		
		return new Precificacao<>(lanches, precoTotal);
	}
	
	
	public List<Precificacao<Lanche>> getLanchesPrecos(List<Lanche> lanches) {
		return lanches.stream()
				.map(l -> getLanchePreco(l))
				.collect(Collectors.toList());
	}
	
	
	public Precificacao<Lanche> getLanchePreco(Lanche lanche) {
		
		List<Promocao> promocoes = TodasPromocoes.ListAllPromo();		
		
		
		List<Desconto> descontos = promocoes.stream()
				//retorna desconto para cada promo
				.map(p -> p.calculo(lanche))
				//retorna descontos diferente de nulo
				.filter(d -> d != null)
				//transforma em lista
				.collect(Collectors.toList());

		
		double preco = lanche.getIngredientes().stream().mapToDouble(Ingrediente::getValor).sum();
		
		
		for(Desconto desconto : descontos)
			preco = desconto.aplly(preco);
		
		
		return new Precificacao<Lanche>(lanche, preco);
	}
}
