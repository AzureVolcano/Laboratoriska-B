package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();  // Враќање на сите песни
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);  // Враќање на песна по ID
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);  // Спремање на песната (нов или ажуриран запис)
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);  // Бришење на песна по ID
    }
}
