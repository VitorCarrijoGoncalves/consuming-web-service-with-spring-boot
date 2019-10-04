package br.com.oab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.oab.model.Album;
import br.com.oab.response.Response;
import br.com.oab.service.AlbumService;

@RestController
@RequestMapping("/albums")
public class AlbumController {
	
	private static final String url = "https://jsonplaceholder.typicode.com/albums";

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
	
	@GetMapping(value = "{id}")
	public @ResponseBody ResponseEntity<Response<Album>> findById(@PathVariable("id") Long id) {
		
		Album album = restTemplate.getForObject(url + "/" + id, Album.class);
		
//		pessoa.setMunicipio("fsdfsfs");
		
		Response<Album> response = new Response<Album>();
//		Optional<Pessoa> optionalPessoa = pessoaService.findById(id);

//		Pessoa pessoa = null;
		
//		if (optionalPessoa.isPresent()) { 
//			pessoa = optionalPessoa.get();
//		}

//		if (pessoa == null) {
//			response.getErrors().add("Register not found id: " + id);
//			return ResponseEntity.badRequest().body(response);
//		}
		
		response.setData(album);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value = "{page}/{count}")
	public ResponseEntity<Response<Page<Album>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<Page<Album>> response = new Response<Page<Album>>();
		Page<Album> albums = albumService.findAll(page, count);
		response.setData(albums);
		return ResponseEntity.ok(response);
	}

}
