package org.example.commands;

import org.example.models.Movie;
import org.example.models.MovieGenre;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveAnyByGenreCommand extends Command {
    private LinkedHashSet<Movie> movieCollection;
    private MovieGenre genre;

    public RemoveAnyByGenreCommand(LinkedHashSet<Movie> movieCollection, MovieGenre genre) {
        this.movieCollection = movieCollection;
        this.genre = genre;
    }

    @Override
    public void execute() {
        Iterator<Movie> iterator = movieCollection.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getGenre() == genre) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Элемент успешно удален.");
        } else {
            System.out.println("Не найден элемент с указанным жанром.");
        }
    }
}
