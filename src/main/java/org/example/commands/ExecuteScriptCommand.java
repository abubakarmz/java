//package org.example.commands;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import org.example.CommandProcessor;
//import org.example.commands.Command;
//
//public class ExecuteScriptCommand extends Command {
//    private String fileName;
//
//    public ExecuteScriptCommand(String fileName) {
//        this.fileName = fileName;
//    }
//
//    @Override
//    public void execute() {
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                CommandProcessor.processCommand(line); //
//            }
//        } catch (IOException e) {
//            System.out.println("Ошибка при чтении файла: " + e.getMessage());
//        }
//    }
//}
