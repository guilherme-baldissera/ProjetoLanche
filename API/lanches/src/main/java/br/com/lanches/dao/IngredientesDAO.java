package br.com.lanches.dao;

import java.util.EnumMap;
import java.util.Map;

import br.com.lanches.models.Ingrediente;
import br.com.lanches.models.IngredientesEnum;

public class IngredientesDAO {

	private static Map<IngredientesEnum, Ingrediente> ingredientes = new EnumMap<IngredientesEnum, Ingrediente>(IngredientesEnum.class);
	
	
	static {
		Ingrediente ingredienteAlface = new Ingrediente(IngredientesEnum.ALFACE, 0.4);
		ingredientes.put(IngredientesEnum.ALFACE, ingredienteAlface);
		
		Ingrediente ingredienteBacon = new Ingrediente(IngredientesEnum.BACON, 2.00);
		ingredientes.put(IngredientesEnum.BACON, ingredienteBacon);
		
		Ingrediente ingredienteHamburguer = new Ingrediente(IngredientesEnum.HAMBURGUER, 3.00);
		ingredientes.put(IngredientesEnum.HAMBURGUER, ingredienteHamburguer);
		
		Ingrediente ingredienteOvo = new Ingrediente(IngredientesEnum.OVO, 0.8);
		ingredientes.put(IngredientesEnum.OVO, ingredienteOvo);
		
		Ingrediente ingredienteQueijo = new Ingrediente(IngredientesEnum.QUEIJO, 1.5);
		ingredientes.put(IngredientesEnum.QUEIJO, ingredienteQueijo);
	}
	
	
	public void adiciona(Ingrediente ingrediente) {
		ingredientes.put(ingrediente.getNome(), ingrediente);
	}
	
	public Ingrediente busca(IngredientesEnum nomeIngred) {
		return ingredientes.get(nomeIngred);
	}
	
	public Ingrediente remove(IngredientesEnum nomeIngred) {
		return ingredientes.remove(nomeIngred);
	}

}
