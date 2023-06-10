package org.example.commands;

import org.example.models.Movie;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class UpdateCommand extends Command {
    private LinkedHashSet<Movie> movieCollection;
    int id;

    public UpdateCommand(LinkedHashSet<Movie> movieCollection, int idEx) {
        this.movieCollection = movieCollection;
        this.id = idEx;
    }

    @Override
    public void execute() {
        Movie movieToUpdate = null;
        boolean isValidId = false;



            try {

                // Ищем элемент с указанным идентификатором в коллекции
                for (Movie movie : movieCollection) {
                    if (movie.getId() == id) {
                        movieToUpdate = movie;
                        isValidId = true;

                        // Обновляем информацию о фильме
                        AddCommand add = new AddCommand();
                        Movie newMovie = add.ex();
                        movieToUpdate.setLastUpdatedDate(LocalDateTime.now());
                        movieToUpdate.setName(newMovie.getName());
                        movieToUpdate.setCoordinates(newMovie.getCoordinates());
                        movieToUpdate.setOscarsCount(newMovie.getOscarsCount());
                        movieToUpdate.setGenre(newMovie.getGenre());
                        movieToUpdate.setMpaaRating(newMovie.getMpaaRating());
                        System.out.println("Элемент с идентификатором " + movieToUpdate.getId() + " успешно обновлен.");

                        break;
                    }
                }

                if (!isValidId) {
                    System.out.println("Элемент с указанным идентификатором не найден. Повторите ввод.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Введите корректный идентификатор.");
            }
        }


}
