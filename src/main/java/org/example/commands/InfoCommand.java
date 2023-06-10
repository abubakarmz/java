package org.example.commands;

import org.example.models.Movie;

import java.util.Date;
import java.util.LinkedHashSet;

import static org.example.Main.getDate;

public class InfoCommand extends Command {
    private LinkedHashSet<Movie> movieCollection;

    public InfoCommand(LinkedHashSet<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    @Override
    public void execute() {
        System.out.println("Тип коллекции: " + movieCollection.getClass().getSimpleName());
        System.out.println("Дата инициализации: " + getDate());
        System.out.println("Количество элементов: " + movieCollection.size());

    }
}
