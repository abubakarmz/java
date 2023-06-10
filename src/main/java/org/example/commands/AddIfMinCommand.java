package org.example.commands;

import org.example.models.Movie;

import java.util.LinkedHashSet;

public class AddIfMinCommand extends Command {
    private LinkedHashSet<Movie> movieCollection;
    private Movie newMovie;

    public AddIfMinCommand(LinkedHashSet<Movie> movieCollection) {
        this.movieCollection = movieCollection;
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

        boolean isMin = true;

        for (Movie movie : movieCollection) {
            if (newMovie.compareTo(movie) >= 0) {
                isMin = false;
                break;
            }
        }

        if (isMin) {
            movieCollection.add(newMovie);
            System.out.println("Фильм успешно добавлен.");
        } else {
            System.out.println("Значение нового фильма не является наименьшим.");
        }
    }
}
