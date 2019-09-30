package br.com.oab.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.oab.model.User;

@Component
public interface UserService {

    User createOrUpdate(User user);

    Optional<User> findById(Long id);

    void delete(Long id);

    Page<User> findAll(int page, int count);

}
