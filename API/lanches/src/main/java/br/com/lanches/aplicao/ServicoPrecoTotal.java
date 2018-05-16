package br.com.lanches.aplicao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lanches.dao.IngredientesDAO;
import br.com.lanches.models.Caixa;
import br.com.lanches.models.Ingrediente;
import br.com.lanches.models.Lanche;
import br.com.lanches.models.Pedido;
import br.com.lanches.models.Precificacao;

@RestController
public class ServicoPrecoTotal {

	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value = "/lanchestotal", consumes = { "application/json" }, produces = { "application/json" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Precificacao getContaFinal(@RequestBody Pedido pedido) {
		IngredientesDAO ingredientesDAO = new IngredientesDAO();
		Caixa caixa = new Caixa();

		if (pedido != null) {			
			final List<Lanche> lanches = pedido.getLanchesPedidos().stream().map(lancheDoPedido -> {
				
				List<Ingrediente> ingredientes = lancheDoPedido.getIngredientesNomes()
						.stream()
						.map(nomeDoIngrediente -> ingredientesDAO.busca(nomeDoIngrediente))
						.collect(Collectors.toList());
				
				return new Lanche((long) lancheDoPedido.getId(), ingredientes);
			})
			.collect(Collectors.toList()); 
			
			Precificacao<List<Lanche>> precificacao = caixa.trazAConta(lanches);
			//System.out.println(precificacao.getPreco());
			return precificacao;
		}else{
			//System.out.println("pedido vazio");
			return null;
		}
		
		
		
		
		
	}
}
