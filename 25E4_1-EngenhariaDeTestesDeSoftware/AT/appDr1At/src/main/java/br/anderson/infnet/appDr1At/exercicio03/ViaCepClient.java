package br.anderson.infnet.appDr1At.exercicio03;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "viaCepClient")
public interface ViaCepClient {

	@GetMapping("/{cep}/json")
	ViaCepResponse buscarPorCep(@PathVariable String cep);

	@GetMapping("/{uf}/{cidade}/{logradouro}/json")
	List<ViaCepResponse> pesquisarCep(@PathVariable String uf, @PathVariable String cidade,
			@PathVariable String logradouro);
}
