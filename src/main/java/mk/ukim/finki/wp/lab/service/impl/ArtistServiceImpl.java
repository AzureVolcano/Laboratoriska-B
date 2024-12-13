package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    // Метод за враќање на сите артисти
    List<Artist> listArtists();

    // Метод за враќање на артист по ID
    Optional<Artist> findArtistById(Long id);

    // Метод за враќање на артист по име и презиме
    Optional<Artist> findArtistByName(String firstName, String lastName);

    // Метод за додавање нов артист
    Artist addArtist(Artist artist);

    List<Artist> findAll();
}
