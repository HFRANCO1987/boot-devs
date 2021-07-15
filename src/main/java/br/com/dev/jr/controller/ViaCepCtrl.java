package br.com.dev.jr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.dev.jr.business.EnderecoBusiness;
import br.com.dev.jr.dto.EnderecoDTO;

@RestController
public class ViaCepCtrl {

	@Autowired
	private EnderecoBusiness enderecoBusiness;	
	
	@PostMapping("/adicionar")
	public void adicionarEndereco(@RequestBody EnderecoDTO enderecoDTO) throws Exception {
		this.enderecoBusiness.adicionarEndereco(enderecoDTO);
	}
	
	@GetMapping("/enderecos")
	public ResponseEntity<List<EnderecoDTO>> listarEnderecos() {
		return ResponseEntity.ok(this.enderecoBusiness.listarTodos());
	}
	
	@GetMapping("/")
	public String mostrarNome() {
		return "Henrique Santiago";
	}

	@GetMapping("/buscarPorCep/{cep}")
	public ResponseEntity<EnderecoDTO> obterCep(@PathVariable(name = "cep") String cep) {

		RestTemplate restTemplate = new RestTemplate();

		String uri = "https://viacep.com.br/ws/{cep}/json/";

		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);

		EnderecoDTO enderecoDTO = restTemplate.getForObject(uri, EnderecoDTO.class, params);

		return ResponseEntity.ok(enderecoDTO);
	}

}
