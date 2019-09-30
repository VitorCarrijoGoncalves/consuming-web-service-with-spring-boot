package br.com.oab.service.impl;

import br.com.oab.model.Pessoa;
import br.com.oab.repository.PessoaRepository;
import br.com.oab.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa createOrUpdate(Pessoa pessoa) {
        return this.pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> findById(Long id) {
        return this.pessoaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.pessoaRepository.deleteById(id);
    }

    @Override
    public Page<Pessoa> findAll(int page, int count) {
        Pageable pages = (Pageable) new PageRequest(page, count);
        return this.pessoaRepository.findAll(pages);
    }
}
