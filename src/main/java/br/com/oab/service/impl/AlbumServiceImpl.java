package br.com.oab.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.oab.model.Album;
import br.com.oab.repository.AlbumRepository;
import br.com.oab.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public Album createOrUpdate(Album album) {
        return this.albumRepository.save(album);
    }

    public Optional<Album> findById(Long id) {
        return this.albumRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.albumRepository.deleteById(id);
    }

    @Override
    public Page<Album> findAll(int page, int count) {
        Pageable pages = (Pageable) new PageRequest(page, count);
        return this.albumRepository.findAll(pages);
    }
}
