package org.example.commands;

import org.example.models.Movie;
import org.example.models.MovieGenre;

import java.util.LinkedHashSet;

public class MaxByGenreCommand extends Command {
    private final LinkedHashSet<Movie> movieCollection;

    public MaxByGenreCommand(LinkedHashSet<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    @Override
    public void execute() {
        if (movieCollection.isEmpty()) {
            System.out.println("Коллекция фильмов пуста.");
            return;
        }

        MovieGenre maxGenre = null;
        Movie maxMovie = null;

        for (Movie movie : movieCollection) {
            if (maxGenre == null || movie.getGenre().compareTo(maxGenre) > 0) {
                maxGenre = movie.getGenre();
                maxMovie = movie;
            }
        }

        if (maxMovie != null) {
            System.out.println("Фильм с максимальным значением жанра: " + maxMovie);
        } else {
            System.out.println("Не найдено фильмов с заданным жанром.");
        }
    }
}
