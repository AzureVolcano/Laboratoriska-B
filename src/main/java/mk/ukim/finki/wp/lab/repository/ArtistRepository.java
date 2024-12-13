package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArtistRepository {

    private List<Artist> artists;

    // Празен конструктор кој инициализира листата со 5 артисти
    public ArtistRepository() {
        this.artists = new ArrayList<>();
        artists.add(new Artist("John", "Doe", "John Doe is a famous musician."));
        artists.add(new Artist("Jane", "Smith", "Jane Smith is an award-winning singer."));
        artists.add(new Artist("Michael", "Johnson", "Michael Johnson is known for his guitar skills."));
        artists.add(new Artist("Emily", "Davis", "Emily Davis is a classical pianist."));
        artists.add(new Artist("Robert", "Brown", "Robert Brown is a famous composer."));
    }

    // Метод за враќање на сите артисти
    public List<Artist> findAll() {
        return artists;
    }

    public Optional<Artist> findById(Long id) {
        return artists.stream()
                .filter(artist -> artist.getId().equals(id))
                .findFirst();
    }

    public Artist save(Artist artist) {
        return null;
    }

    public Optional<Artist> findByName(String firstName, String lastName) {
    }
}
