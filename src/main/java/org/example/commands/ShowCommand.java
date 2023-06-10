package org.example.commands;

import org.example.models.Movie;

import java.util.LinkedHashSet;

public class ShowCommand extends Command {
    private LinkedHashSet<Movie> movieCollection;

    public ShowCommand(LinkedHashSet<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    @Override
    public void execute() {
        for (Movie movie : movieCollection) {
            System.out.println(movie.toString());
        }
    }
}
