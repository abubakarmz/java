package org.example.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class MovieCollection {
    private final LinkedHashSet<Movie> movies;
    private final LocalDateTime creationDate;

    public MovieCollection() {
        movies = new LinkedHashSet<>();
        creationDate = LocalDateTime.now();
    }

    /**
     * Добавляет фильм в коллекцию.
     *
     * @param movie Фильм для добавления.
     */
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    /**
     * Обновляет информацию о фильме в коллекции по его ID.
     *
     * @param id    ID фильма для обновления.
     * @param movie Новый объект фильма.
     * @return true, если фильм успешно обновлен, false в противном случае.
     */
    public boolean updateMovie(long id, Movie movie) {
        for (Movie m : movies) {
            if (m.getId() == id) {
                m.setName(movie.getName());
                m.setCoordinates(movie.getCoordinates());
                m.setOscarsCount(movie.getOscarsCount());
                m.setGenre(movie.getGenre());
                m.setMpaaRating(movie.getMpaaRating());
                m.setOperator(movie.getOperator());
                return true;
            }
        }
        return false;
    }

    /**
     * Удаляет фильм из коллекции по его ID.
     *
     * @param id ID фильма для удаления.
     * @return true, если фильм успешно удален, false в противном случае.
     */
    public boolean removeMovieById(long id) {
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Очищает коллекцию - удаляет все фильмы.
     */
    public void clearCollection() {
        movies.clear();
    }

    /**
     * Возвращает количество фильмов в коллекции.
     *
     * @return Количество фильмов.
     */
    public int getCollectionSize() {
        return movies.size();
    }

    /**
     * Проверяет, содержит ли коллекция фильмы.
     *
     * @return true, если коллекция пуста, false в противном случае.
     */
    public boolean isCollectionEmpty() {
        return movies.isEmpty();
    }

    /**
     * Возвращает список всех фильмов в коллекции.
     *
     * @return Список фильмов.
     */
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    /**
     * Возвращает дату инициализации коллекции.
     *
     * @return Дата инициализации коллекции.
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
