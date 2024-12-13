package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    // JpaRepository обезбедува вградените CRUD методи: save(), findById(), findAll(), deleteById()

    // Дополнителни методи, ако се потребни:
    Album findByName(String name);  // Пребарување на албум по име
}
