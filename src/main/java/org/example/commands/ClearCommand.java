package org.example.commands;

import org.example.models.Movie;

import java.util.LinkedHashSet;

public class ClearCommand extends Command {
    private LinkedHashSet<Movie> movieCollection;

    public ClearCommand(LinkedHashSet<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    @Override
    public void execute() {
        movieCollection.clear();
        System.out.println("Коллекция успешно очищена.");
    }
}
