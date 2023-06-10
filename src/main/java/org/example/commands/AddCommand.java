package org.example.commands;

import java.util.Scanner;
import org.example.models.*;

import static org.example.Main.addMovie;

public class AddCommand extends Command {

    public Movie ex() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        long x = 0;
        float y = 0;
        int oscarsCount = 0;
        MovieGenre genre = null;
        MpaaRating mpaaRating = null;

        // Ввод названия фильма
        do {
            System.out.print("Введите название фильма: ");
            name = scanner.nextLine().trim();
        } while (name.isEmpty());

        // Ввод координаты X
        boolean validX = false;
        do {
            System.out.print("Введите координату X: ");
            try {
                x = Long.parseLong(scanner.nextLine());
                validX = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода числового значения. Введите корректное число.");
            }
        } while (!validX);

        // Ввод координаты Y
        boolean validY = false;
        do {
            System.out.print("Введите координату Y: ");
            try {
                y = Float.parseFloat(scanner.nextLine());
                validY = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода числового значения. Введите корректное число.");
            }
        } while (!validY);

        // Ввод количества оскаров
        boolean validOscars = false;
        do {
            System.out.print("Введите количество оскаров: ");
            try {
                oscarsCount = Integer.parseInt(scanner.nextLine());
                validOscars = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода числового значения. Введите корректное число.");
            }
        } while (!validOscars);

        // Ввод жанра фильма
        boolean validGenre = false;
        do {
            System.out.print("Введите жанр фильма (WESTERN, COMEDY, HORROR, FANTASY, SCIENCE_FICTION): ");
            String genreStr = scanner.nextLine().trim().toUpperCase();
            try {
                genre = MovieGenre.valueOf(genreStr);
                validGenre = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода значения жанра. Введите корректное значение.");
            }
        } while (!validGenre);

        // Ввод рейтинга MPAA
        boolean validRating = false;
        do {
            System.out.print("Введите рейтинг MPAA (G, PG, PG_13, R, NC_17): ");
            String ratingStr = scanner.nextLine().trim().toUpperCase();
            try {
                mpaaRating = MpaaRating.valueOf(ratingStr);
                validRating = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода значения рейтинга. Введите корректное значение.");
            }
        } while (!validRating);

        // Создание объекта фильма
        Movie movie = new Movie(name, new Coordinates((int) x, y), oscarsCount, genre, mpaaRating);

        return movie;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        long x = 0;
        float y = 0;
        int oscarsCount = 0;
        MovieGenre genre = null;
        MpaaRating mpaaRating = null;

        // Ввод названия фильма
        do {
            System.out.print("Введите название фильма: ");
            name = scanner.nextLine().trim();
        } while (name.isEmpty());

        // Ввод координаты X
        boolean validX = false;
        do {
            System.out.print("Введите координату X: ");
            try {
                x = Long.parseLong(scanner.nextLine());
                validX = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода числового значения. Введите корректное число.");
            }
        } while (!validX);

        // Ввод координаты Y
        boolean validY = false;
        do {
            System.out.print("Введите координату Y: ");
            try {
                y = Float.parseFloat(scanner.nextLine());
                validY = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода числового значения. Введите корректное число.");
            }
        } while (!validY);

        // Ввод количества оскаров
        boolean validOscars = false;
        do {
            System.out.print("Введите количество оскаров: ");
            try {
                oscarsCount = Integer.parseInt(scanner.nextLine());
                validOscars = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода числового значения. Введите корректное число.");
            }
        } while (!validOscars);

        // Ввод жанра фильма
        boolean validGenre = false;
        do {
            System.out.print("Введите жанр фильма (WESTERN, COMEDY, HORROR, FANTASY, SCIENCE_FICTION): ");
            String genreStr = scanner.nextLine().trim().toUpperCase();
            try {
                genre = MovieGenre.valueOf(genreStr);
                validGenre = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода значения жанра. Введите корректное значение.");
            }
        } while (!validGenre);

        // Ввод рейтинга MPAA
        boolean validRating = false;
        do {
            System.out.print("Введите рейтинг MPAA (G, PG, PG_13, R, NC_17): ");
            String ratingStr = scanner.nextLine().trim().toUpperCase();
            try {
                mpaaRating = MpaaRating.valueOf(ratingStr);
                validRating = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода значения рейтинга. Введите корректное значение.");
            }
        } while (!validRating);

        // Создание объекта фильма
        Movie movie = new Movie(name, new Coordinates((int) x, y), oscarsCount, genre, mpaaRating);

        // Добавление объекта фильма в коллекцию
        addMovie(movie);

        System.out.println("Фильм успешно добавлен в коллекцию.");
    }
}
