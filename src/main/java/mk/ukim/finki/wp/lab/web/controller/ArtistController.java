package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.SongService;
import mk.ukim.finki.wp.lab.service.impl.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService artistService;
    private final SongService songService;

    @Autowired
    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    // 1. Прикажување на формата за избор на артист
    @GetMapping("/add/{songId}")
    public String getArtistsPage(@PathVariable Long songId, Model model) {
        Song song = songService.findById(songId);
        if (song == null) {
            return "redirect:/songs";  // Ако песната не постои, пренасочување на листата со песни
        }

        List<Artist> artists = artistService.findAll();  // Добиј ги сите артисти
        model.addAttribute("song", song);
        model.addAttribute("artists", artists);
        return "artistsList";  // Враќање на шаблонот artistsList.html
    }

    // 2. Додавање артист на песна
    @PostMapping("/add/{songId}")
    public String addArtistToSong(@PathVariable Long songId, @RequestParam Long artistId) {
        Song song = songService.findById(songId);
        Artist artist = artistService.findById(artistId);

        if (song != null && artist != null) {
            song.getPerformers().add(artist);  // Додавање на артист во листата на изведувачи
            songService.save(song);  // Ажурирање на песната
        }

        return "redirect:/songs";  // Редиректирање на листата со песни
    }
}
