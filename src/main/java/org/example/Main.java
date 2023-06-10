package org.example;

import org.example.commands.*;
import org.example.models.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class Main {

    private static final Date date = new Date();

    private static LinkedHashSet<Movie> main = new LinkedHashSet<>();

    public static Date getDate(){
        return date;
    }
    // set
    public static void addMovie(Movie movie){
        main.add(movie);
    }

    // get
    public static LinkedHashSet<Movie> getMovie(){
        return main;
    }



    // Main
    public static void main(String[] args) {

        addMovie(new Movie("avatar", new Coordinates(30, 30), 3, MovieGenre.HORROR, MpaaRating.G));
        addMovie(new Movie("avatar 2", new Coordinates(30, 30), 3, MovieGenre.FANTASY, MpaaRating.PG_13));
        addMovie(new Movie("avatar 3", new Coordinates(30, 30), 3, MovieGenre.COMEDY, MpaaRating.R));

        Scanner scanner = new Scanner(System.in);
        CommandProcessor processor = new CommandProcessor();

        while (true) {
            System.out.print("Введите команду: ");
            processor.processCommand(scanner.nextLine());

        }

    }



}
