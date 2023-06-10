package org.example.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.commands.Command;
import org.example.models.LocalDateTimeTypeAdapter;
import org.example.models.Movie;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;

public class SaveCommand extends Command {
    private LinkedHashSet<Movie> movieCollection;
    private String fileName;

    public SaveCommand(LinkedHashSet<Movie> movieCollection, String fileName) {
        this.movieCollection = movieCollection;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
        String json = gson.toJson(movieCollection);

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            fos.write(bytes);
            System.out.println("Коллекция успешно сохранена в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении коллекции в файл: " + e.getMessage());
        }
    }
}
