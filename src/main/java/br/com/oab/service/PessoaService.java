package br.com.oab.service;

import br.com.oab.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface PessoaService {

    Pessoa createOrUpdate(Pessoa pessoa);

    Optional<Pessoa> findById(Long id);

    void delete(Long id);

    Page<Pessoa> findAll(int page, int count);

}
