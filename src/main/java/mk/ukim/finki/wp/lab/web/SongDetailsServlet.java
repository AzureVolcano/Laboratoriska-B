package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import mk.ukim.finki.wp.lab.service.impl.SongServiceImpl;

import java.io.IOException;

@WebServlet("/songDetails")
public class SongDetailsServlet extends HttpServlet {

    private final SongService songService;

    // Конструктор кој рачно креира инстанца на SongService
    public SongDetailsServlet() {
        this.songService = new SongServiceImpl(new SongRepository(), new ArtistRepository());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Прочитување на trackId од параметарот во URL
        String trackId = request.getParameter("trackId");
        Song song = songService.findSongByTrackId(trackId); // Пребарување на песната по trackId

        if (song != null) {
            request.setAttribute("song", song); // Поставување на песната како атрибут во барањето
            request.getRequestDispatcher("/WEB-INF/templates/songDetails.html").forward(request, response); // Проследување на барањето до шаблонот
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Song not found"); // Ако песната не е пронајдена, враќа грешка
        }
    }
}
