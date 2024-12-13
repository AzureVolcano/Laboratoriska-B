package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Song;
import java.util.List;

public interface SongService {
    // Метод за враќање на сите песни
    List<Song> findAll();

    // Метод за наоѓање песна по ID
    Song findById(Long id);

    // Метод за зачувување на песна (create или update)
    void save(Song song);

    // Метод за бришење песна по ID
    void delete(Long id);
}
