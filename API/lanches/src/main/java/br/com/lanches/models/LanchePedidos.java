package br.com.lanches.models;

import java.util.List;

public class LanchePedidos {
	Integer id;
	List<IngredientesEnum> ingredientesNomes;
	
	
	
	public LanchePedidos() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<IngredientesEnum> getIngredientesNomes() {
		return ingredientesNomes;
	}
	public void setIngredientesNomes(List<IngredientesEnum> ingredientesNomes) {
		this.ingredientesNomes = ingredientesNomes;
	}
	
	
	
}
