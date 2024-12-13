package mk.ukim.finki.wp.lab.model;

public class Artist {

    private Long id; // ID на артистот
    private String firstName; // Име на артистот
    private String lastName; // Презиме на артистот
    private String bio; // Биографија на артистот

    // Празен конструктор
    public Artist() {}

    // Конструктор со параметри
    public Artist(String firstName, String lastName, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }

    // Гетери и сетери за атрибутите
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
