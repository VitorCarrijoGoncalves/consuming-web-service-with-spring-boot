package br.com.oab.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.oab.model.Album;

@Component
public interface AlbumService {

    Album createOrUpdate(Album album);

    Optional<Album> findById(Long id);

    void delete(Long id);

    Page<Album> findAll(int page, int count);

}
