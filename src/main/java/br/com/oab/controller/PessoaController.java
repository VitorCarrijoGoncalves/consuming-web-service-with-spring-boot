package br.com.oab.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.oab.model.Pessoa;
import br.com.oab.response.Response;
import br.com.oab.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	private static final String url = "http://localhost:8080/pessoas";
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "{id}")
	public @ResponseBody ResponseEntity<Response<Pessoa>> findById(@PathVariable("id") Long id) {
		
		Pessoa pessoa = restTemplate.getForObject(url + "/" + id, Pessoa.class);
		
		Response<Pessoa> response = new Response<Pessoa>();
		Optional<Pessoa> optionalPessoa = pessoaService.findById(id);

		if (optionalPessoa.isPresent()) { 
			pessoa = optionalPessoa.get();
		}

		if (pessoa == null) {
			response.getErrors().add("Register not found id: " + id);
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(pessoa);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "{page}/{count}")
	public ResponseEntity<Response<Page<Pessoa>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<Page<Pessoa>> response = new Response<Page<Pessoa>>();
		Page<Pessoa> pessoas = pessoaService.findAll(page, count);
		response.setData(pessoas);
		return ResponseEntity.ok(response);
	}

}
