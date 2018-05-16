package br.com.lanches.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.lanches.dao.IngredientesDAO;
import br.com.lanches.models.Caixa;
import br.com.lanches.models.Ingrediente;
import br.com.lanches.models.IngredientesEnum;
import br.com.lanches.models.Lanche;
import br.com.lanches.models.Precificacao;

public class CaixaTest {

	@Test
	public void testMultiplosLanches() {
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();
		List<Ingrediente> ingredientes1 = new ArrayList<>();
		List<Ingrediente> ingredientes2 = new ArrayList<>();
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.ALFACE));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));

		Lanche lanche1 = new Lanche(1l, ingredientes1);
		
		ingredientes2.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		ingredientes2.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		ingredientes2.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		
		Lanche lanche2 = new Lanche(2l, ingredientes2);
		
		List<Lanche> lanches = new ArrayList<>();
		lanches.add(lanche1);
		lanches.add(lanche2);
		
		Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
		
		assertEquals(14.16, precificacao.getPreco(),0.01);
	}
	
	@Test
	public void testXBacon(){
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();
		List<Ingrediente> ingredientes1 = new ArrayList<>();
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.BACON));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		
		Lanche lanche = new Lanche(1l, ingredientes1);
		List<Lanche> lanches = new ArrayList<>();
		lanches.add(lanche);
		
		Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
		
		assertEquals(6.5, precificacao.getPreco(),0.01);

	}
	
	@Test
	public void testXBurguer(){
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();
		List<Ingrediente> ingredientes1 = new ArrayList<>();
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		
		Lanche lanche = new Lanche(1l, ingredientes1);
		List<Lanche> lanches = new ArrayList<>();
		lanches.add(lanche);
		
		Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
		
		assertEquals(4.5, precificacao.getPreco(),0.01);
	}
	
	@Test
	public void testXEgg(){
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();
		List<Ingrediente> ingredientes1 = new ArrayList<>();
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.OVO));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		
		Lanche lanche = new Lanche(1l, ingredientes1);
		List<Lanche> lanches = new ArrayList<>();
		lanches.add(lanche);
		
		Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
		
		assertEquals(5.3, precificacao.getPreco(),0.01);
	}
	
	@Test
	public void testXEggBacon(){
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();
		List<Ingrediente> ingredientes1 = new ArrayList<>();
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.BACON));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.OVO));
		
		Lanche lanche = new Lanche(1l, ingredientes1);
		List<Lanche> lanches = new ArrayList<>();
		lanches.add(lanche);
		
		Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
		
		assertEquals(7.3, precificacao.getPreco(),0.01);
	}
	
	@Test
	public void testPromoLight(){
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();
		List<Ingrediente> ingredientes1 = new ArrayList<>();
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.ALFACE));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.OVO));
		
		Lanche lanche = new Lanche(1l, ingredientes1);
		List<Lanche> lanches = new ArrayList<>();
		lanches.add(lanche);
		
		Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
		assertEquals(5.13, precificacao.getPreco(),0.01);
	}
	
	@Test
	public void testPromoMuitaCarne(){
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();
		List<Ingrediente> ingredientes1 = new ArrayList<>();
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		
		Lanche lanche = new Lanche(1l, ingredientes1);
		List<Lanche> lanches = new ArrayList<>();
		lanches.add(lanche);
		
		Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
		assertEquals(6.0, precificacao.getPreco(),0.01);
	}
	
	@Test
	public void testPromoMuitaQueijo(){
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();
		List<Ingrediente> ingredientes1 = new ArrayList<>();
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		
		Lanche lanche = new Lanche(1l, ingredientes1);
		List<Lanche> lanches = new ArrayList<>();
		lanches.add(lanche);
		
		Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
		assertEquals(3.0, precificacao.getPreco(),0.01);
	}
	
	@Test
	public void testTodasPromo(){
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();
		List<Ingrediente> ingredientes1 = new ArrayList<>();
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.ALFACE));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.HAMBURGUER));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		ingredientes1.add(ingredientesDAO.busca(IngredientesEnum.QUEIJO));
		
		Lanche lanche = new Lanche(1l, ingredientes1);
		List<Lanche> lanches = new ArrayList<>();
		lanches.add(lanche);
		
		Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
		assertEquals(8.46, precificacao.getPreco(),0.01);
	}
	
}
