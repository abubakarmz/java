package org.example.commands;

import org.example.models.Movie;

import java.util.LinkedHashSet;

public class AddIfMaxCommand extends Command {
    private LinkedHashSet<Movie> movieCollection;
    private Movie newMovie;

    public AddIfMaxCommand(LinkedHashSet<Movie> movieCollection/*,  Movie newMovie*/) {
        this.movieCollection = movieCollection;
//        this.newMovie = newMovie;
    }

    @Override
    public void execute() {
        AddCommand add = new AddCommand();

        newMovie = add.ex();

        if (movieCollection.isEmpty()) {
            movieCollection.add(newMovie);
            System.out.println("Фильм успешно добавлен.");
            return;
        }

        Movie maxMovie = getMaxMovie();

        if (newMovie.compareTo(maxMovie) > 0) {
            movieCollection.add(newMovie);
            System.out.println("Фильм успешно добавлен.");
        } else {
            System.out.println("Значение нового фильма не превышает значение наибольшего элемента коллекции.");
        }
    }

    private Movie getMaxMovie() {
        Movie maxMovie = null;

        for (Movie movie : movieCollection) {
            if (maxMovie == null || movie.compareTo(maxMovie) > 0) {
                maxMovie = movie;
            }
        }

        return maxMovie;
    }
}
