package org.example.models;

import java.time.LocalDateTime;

public class Movie implements Comparable<Movie> {
    private static long counter = 0;

    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    public LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long oscarsCount; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле не может быть null
    private MpaaRating mpaaRating; //Поле не может быть null
    private Person operator; //Поле может быть null



    public Movie(String name, Coordinates coordinates, long oscarsCount, MovieGenre genre, MpaaRating mpaaRating) {
        this.id = generateUniqueId();
        this.name = validateString(name);
        this.coordinates = validateCoordinates(coordinates);
        this.creationDate = LocalDateTime.now();
        this.oscarsCount = validateOscarsCount(oscarsCount);
        this.genre = validateGenre(genre);
        this.mpaaRating = validateMpaaRating(mpaaRating);
    }

    // Validate

    private synchronized long generateUniqueId() {
        return ++counter;
    }

    private String validateString(String value) {
        // Проверка, что значение строки не является null или пустой строкой
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("String value cannot be null or empty.");
        }
        return value;
    }

    private Coordinates validateCoordinates(Coordinates value) {
        // Проверка, что значение объекта Coordinates не является null
        if (value == null) {
            throw new IllegalArgumentException("Coordinates value cannot be null.");
        }
        return value;
    }

    private long validateOscarsCount(long value) {
        // Проверка, что значение oscarsCount больше 0
        if (value <= 0) {
            throw new IllegalArgumentException("Oscars count must be greater than 0.");
        }
        return value;
    }

    private MovieGenre validateGenre(MovieGenre value) {
        // Проверка, что значение объекта MovieGenre не является null
        if (value == null) {
            throw new IllegalArgumentException("Genre value cannot be null.");
        }
        return value;
    }

    private MpaaRating validateMpaaRating(MpaaRating value) {
        // Проверка, что значение объекта MpaaRating не является null
        if (value == null) {
            throw new IllegalArgumentException("Mpaa rating value cannot be null.");
        }
        return value;
    }

    // Set and  Get

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public LocalDateTime getLastUpdatedDate() {
        return creationDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.creationDate = lastUpdatedDate;
    }


    public long getOscarsCount() {
        return oscarsCount;
    }

    public void setOscarsCount(long oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Person getOperator() {
        return operator;
    }

    public void setOperator(Person operator) {
        this.operator = operator;
    }



    @Override
    public int compareTo(Movie otherMovie) {
        if (this.equals(otherMovie)) {
            return 0;
        }

        int result = this.genre.compareTo(otherMovie.genre);

        if (result == 0) {
            result = this.mpaaRating.compareTo(otherMovie.mpaaRating);
        }

        if (result == 0) {
            result = Long.compare(this.oscarsCount, otherMovie.oscarsCount);
        }

        return result;
    }




    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", oscarsCount=" + oscarsCount +
                ", genre=" + genre +
                ", mpaaRating=" + mpaaRating +
                ", operator=" + operator +
                '}';
    }
}
