package org.example.commands;

import org.example.models.Movie;

import java.util.*;

public class PrintFieldDescendingMpaaRatingCommand extends Command {
    private Set<Movie> movies;

    public PrintFieldDescendingMpaaRatingCommand(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public void execute() {
        List<Movie> movieList = new ArrayList<>(movies);

        // Сортировка списка фильмов по убыванию поля mpaaRating
        movieList.sort(Comparator.comparing(Movie::getMpaaRating).reversed());

        // Вывод значений поля mpaaRating
        for (Movie movie : movieList) {
            System.out.println(movie.getMpaaRating());
        }
    }
}
