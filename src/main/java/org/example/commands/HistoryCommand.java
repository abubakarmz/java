package org.example.commands;

import java.util.ArrayList;
import java.util.List;

public class HistoryCommand extends Command {
    private static final List<String> commandHistory = new ArrayList<>();

    private String command;

    public HistoryCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute(){
        if (commandHistory.size() > 13) {
            commandHistory.remove(0);
        }
        commandHistory.add(command);

    }
    public void show() {

        for (String cmd : commandHistory) {
            System.out.println(cmd);
        }
    }
}
