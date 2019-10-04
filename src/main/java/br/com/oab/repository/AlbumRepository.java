package br.com.oab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.oab.model.Album;

@Repository
public interface AlbumRepository extends MongoRepository<Album, Long> {

}
