package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServlet implements ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServlet(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();  // Враќање на сите артисти
    }

    @Override
    public Optional<Artist> findArtistById(Long id) {
        return artistRepository.findById(id);  // Пребарување артист по ID
    }

    @Override
    public Optional<Artist> findArtistByName(String firstName, String lastName) {
        return artistRepository.findByName(firstName, lastName);  // Пребарување артист по име и презиме
    }

    @Override
    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);  // Додавање нов артист
    }
}
