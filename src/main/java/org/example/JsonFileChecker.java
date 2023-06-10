package org.example;

import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileChecker {
    public static boolean isJsonFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            JsonParser parser = new JsonParser();
            parser.parse(reader);
            return true; // Файл является валидным JSON
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            // При парсинге файла возникла ошибка, что означает, что файл не является валидным JSON
            return false;
        }
        return false;
    }
}
