package br.com.oab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.oab.model.Pessoa;

@SpringBootApplication
public class PessoaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PessoaApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Pessoa pessoa = restTemplate.getForObject("http://localhost:8080/pessoas", Pessoa.class);
			System.out.println(pessoa.toString());
		};
	}
	
}
