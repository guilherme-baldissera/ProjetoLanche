package br.com.lanches.models;

import java.util.ArrayList;
import java.util.List;

public class TodasPromocoes {

	public static List<Promocao> ListAllPromo() {
		
		List<Promocao> promocoes = new ArrayList<>();
		promocoes.add(new PromoMuitaCarne());
		promocoes.add(new PromoMuitoQueijo());
		promocoes.add(new PromoLight());
		
		return promocoes;
	}
}
