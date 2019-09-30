package br.com.oab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.oab.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
