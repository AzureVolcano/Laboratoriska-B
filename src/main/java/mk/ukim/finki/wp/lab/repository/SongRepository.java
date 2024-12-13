package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    // JpaRepository обезбедува вградените CRUD методи: save(), findById(), findAll(), deleteById()

    // Дополнителни методи, ако се потребни:
    Song findByTrackId(String trackId);  // Пребарување на песна по trackId
}
