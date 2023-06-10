package org.example.commands;

import org.example.models.Movie;

import java.util.LinkedHashSet;

public class RemoveByIdCommand extends Command{

    LinkedHashSet<Movie> movieCollection = new LinkedHashSet<>();
    int id;
    public RemoveByIdCommand(LinkedHashSet<Movie> movie, int id){
        this.movieCollection = movie;
        this.id = id;
    }

    @Override
    public void execute() {


        Movie movieToRemove = null;
        for (Movie movie : movieCollection) {
            if (movie.getId() == id) {
                movieToRemove = movie;
            }
        }

        if (movieToRemove != null) {
            movieCollection.remove(movieToRemove);
            System.out.println("Элемент успешно удален.");

        } else{
            System.out.println("Элемент с указанным id не найден.");
            return;
        }


    }
}
