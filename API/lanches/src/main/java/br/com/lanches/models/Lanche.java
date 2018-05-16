package br.com.lanches.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lanche {
	Long id;
	List<Ingrediente> ingredientes;
	
	public Lanche(){
		
	}
	
	public Lanche(Long id, List<Ingrediente> ingredientes) {
		this.id = id;
		this.ingredientes = ingredientes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
}
