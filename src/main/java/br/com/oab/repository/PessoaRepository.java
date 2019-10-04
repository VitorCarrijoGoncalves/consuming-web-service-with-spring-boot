package br.com.oab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.oab.model.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, Long> {

}
