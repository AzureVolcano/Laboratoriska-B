package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SongListServlet", urlPatterns = "/listSongs")
public class SongListServlet extends HttpServlet {

    private final SongService songService;

    @Autowired
    public SongListServlet(SongService songService) {
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Song> songs = songService.findAllSongs();
        req.setAttribute("songs", songs);
        req.getRequestDispatcher("/WEB-INF/listSongs.html").forward(req, resp);
    }
}
