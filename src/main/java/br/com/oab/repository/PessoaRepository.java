package br.com.oab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.oab.model.Pessoa;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, Long> {

}
