package br.com.oab.service.impl;

import br.com.oab.model.Pessoa;
import br.com.oab.model.User;
import br.com.oab.repository.PessoaRepository;
import br.com.oab.repository.UserRepository;
import br.com.oab.service.PessoaService;
import br.com.oab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createOrUpdate(User user) {
        return this.userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAll(int page, int count) {
        Pageable pages = (Pageable) new PageRequest(page, count);
        return this.userRepository.findAll(pages);
    }
}
