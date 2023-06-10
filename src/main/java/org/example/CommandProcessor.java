package org.example;

import org.example.commands.*;
import org.example.models.MovieGenre;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.example.Main.getDate;
import static org.example.Main.getMovie;

public class CommandProcessor {



    public static void processCommand(String input) {
        // Разбиваем ввод на команду и аргументы


        String[] parts = input.trim().split("\\s+", 2);
        String command = parts[0].toLowerCase();
        String arguments = parts.length > 1 ? parts[1] : "";
        HistoryCommand history = new HistoryCommand(command);
        history.execute();

        // Вызываем соответствующий метод команды
        switch (command) {

            case "help":
                HelpCommand help = new HelpCommand();
                help.execute();
                break;

            case "info":
                InfoCommand info = new InfoCommand(getMovie());
                info.execute();
                break;

            case "show":
                ShowCommand show = new ShowCommand(getMovie());
                show.execute();
                break;

            case "add":
                // Вызываем метод для команды add и передаем аргументы
                AddCommand add = new AddCommand();
                add.execute();
                break;

            case "update":
                try {
                    int i = Integer.parseInt(arguments);
                    UpdateCommand update = new UpdateCommand(getMovie(), i);
                    update.execute();
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода индекса. Укажите целочисленное значение для индекса.");
                }

                break;

            case "remove_by_id":
                try{
                    int i = Integer.parseInt(arguments);
                    RemoveByIdCommand removebyid = new RemoveByIdCommand(getMovie(), i);
                    removebyid.execute();

                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода индекса. Укажите целочисленное значение для индекса.");
                }
                break;

            case "clear":
                ClearCommand clear = new ClearCommand(getMovie());
                clear.execute();
                break;

            case "save":
                if (arguments.endsWith(".json")) {
                    SaveCommand save = new SaveCommand(getMovie(), arguments);
                    save.execute();
                } else {
                    System.out.println("Некорректный формат файла. Допустимый формат: .json");
                }
                break;
//            case "execute_script":
//                String fileName = arguments; // Метод extractFileName нужно реализовать для извлечения имени файла из аргументов команды
//                ExecuteScriptCommand executeScriptCommand = new ExecuteScriptCommand(fileName);
//                executeScriptCommand.execute();
//                break;
//



            case "exit":
                ExitCommand exit = new ExitCommand();
                exit.execute();
                break;

            case "add_if_max":
                AddIfMaxCommand addifmax = new AddIfMaxCommand(getMovie());
                addifmax.execute();
                break;

            case "add_if_min":
                AddIfMinCommand addifmin = new AddIfMinCommand(getMovie());
                addifmin.execute();
                break;

            case "history":
                history.show();
                break;

            case "remove_any_by_genre":
                try {
                    String genreStr = arguments.toUpperCase();
                    MovieGenre genre = MovieGenre.valueOf(genreStr);
                    RemoveAnyByGenreCommand removeByGenreCommand = new RemoveAnyByGenreCommand(getMovie(), genre);
                    removeByGenreCommand.execute();
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка ввода значения жанра. Введите корректное значение (WESTERN, COMEDY, HORROR, FANTASY, SCIENCE_FICTION) .");
                }
                break;



            case "max_by_genre":
                MaxByGenreCommand maxByGenreCommand = new MaxByGenreCommand(getMovie());
                maxByGenreCommand.execute();
                break;

            case "print_field_descending_mpaa_rating":
                PrintFieldDescendingMpaaRatingCommand printFieldDescendingMpaaRatingCommand = new PrintFieldDescendingMpaaRatingCommand(getMovie());
                printFieldDescendingMpaaRatingCommand.execute();
                break;


            // Добавьте обработку других команд
            default:
                System.out.println("Неизвестная команда.");
        }




    }




    // Добавьте методы для обработки других команд
}
