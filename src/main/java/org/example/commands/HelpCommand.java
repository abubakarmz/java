package org.example.commands;

public class HelpCommand extends Command {
    @Override
    public void execute() {
        System.out.println("Список доступных команд:");
        System.out.println("help - вывести справку по доступным командам");
        System.out.println("info - вывести информацию о коллекции");
        System.out.println("show - вывести все элементы коллекции в строковом представлении");
        System.out.println("add {element} - добавить новый элемент в коллекцию");
        System.out.println("update id {element} - обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id - удалить элемент из коллекции по его id");
        System.out.println("clear - очистить коллекцию");
        System.out.println("save - сохранить коллекцию в файл");
        System.out.println("execute_script file_name - считать и исполнить скрипт из указанного файла");
        System.out.println("exit - завершить программу (без сохранения в файл)");
        System.out.println("add_if_max {element} - добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        System.out.println("add_if_min {element} - добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        System.out.println("history - вывести последние 13 команд (без их аргументов)");
        System.out.println("remove_any_by_genre genre - удалить из коллекции один элемент, значение поля genre которого эквивалентно заданному");
        System.out.println("max_by_genre - вывести любой объект из коллекции, значение поля genre которого является максимальным");
        System.out.println("print_field_descending_mpaa_rating - вывести значения поля mpaaRating всех элементов в порядке убывания");
    }
}