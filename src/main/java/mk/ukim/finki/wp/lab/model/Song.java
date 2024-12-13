package mk.ukim.finki.wp.lab.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Генерирање на уникатен ID за секоја песна
    private Long id;  // ID на песната

    private String trackId;  // Уникатен trackId за песната
    private String title;    // Наслов на песната
    private String genre;    // Жанр на песната
    private int releaseYear; // Година на издавање песната

    @ManyToOne  // Врска е многу песни на еден албум
    private Album album;  // Албум на кој припаѓа песната

    // Празен конструктор
    public Song() {}

    // Конструктор со параметри
    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
    }

    // Гетери и сетери за атрибутите
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public <E> List<E> getPerformers() {
        return null;
    }
}
