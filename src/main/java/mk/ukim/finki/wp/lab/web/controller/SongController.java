package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    @Autowired
    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    // 1. Прикажување на сите песни
    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        List<Song> songs = songService.findAll();  // Добиј ги сите песни
        model.addAttribute("songs", songs);
        model.addAttribute("error", error);  // Додавање на грешка во моделот ако постои
        return "listSongs";  // Враќање на погледот listSongs.html
    }

    // 2. Додавање на нова песна
    @PostMapping("/add")
    public String saveSong(@RequestParam String title, @RequestParam String trackId,
                           @RequestParam String genre, @RequestParam int releaseYear,
                           @RequestParam Long albumId) {
        Album album = albumService.findAll().stream().filter(a -> a.getId().equals(albumId)).findFirst().orElse(null);
        if (album != null) {
            Song newSong = new Song(trackId, title, genre, releaseYear, album);
            songService.save(newSong);  // Зачувување на новата песна
        }
        return "redirect:/songs";  // Редиректирање на листата со песни
    }

    // 3. Уредување на песна
    @GetMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId, Model model) {
        Song song = songService.findById(songId);  // Пребарување на песната по id
        if (song != null) {
            List<Album> albums = albumService.findAll();  // Добиј ги сите албуми
            model.addAttribute("song", song);
            model.addAttribute("albums", albums);
            return "editSong";  // Враќање на форма за уредување
        }
        return "redirect:/songs";  // Ако песната не постои, пренасочување на листата
    }

    @PostMapping("/edit/{songId}")
    public String updateSong(@PathVariable Long songId, @RequestParam String title,
                             @RequestParam String trackId, @RequestParam String genre,
                             @RequestParam int releaseYear, @RequestParam Long albumId) {
        Song song = songService.findById(songId);  // Пребарување на песната по id
        Album album = albumService.findAll().stream().filter(a -> a.getId().equals(albumId)).findFirst().orElse(null);

        if (song != null && album != null) {
            song.setTitle(title);
            song.setTrackId(trackId);
            song.setGenre(genre);
            song.setReleaseYear(releaseYear);
            song.setAlbum(album);
            songService.save(song);  // Ажурирање на песната
        }
        return "redirect:/songs";  // Редиректирање на листата со песни
    }

    // 4. Бришење на песна
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.delete(id);  // Бришење на песната
        return "redirect:/songs";  // Редиректирање на листата со песни
    }
}
