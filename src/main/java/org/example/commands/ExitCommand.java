package org.example.commands;


public class ExitCommand extends Command {
    @Override
    public void execute() {
        System.out.println("Программа завершает работу.");
        System.exit(0);
    }
}

