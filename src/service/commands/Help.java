package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class Help extends Command {
    private HashMap<String, Command> commands;
    public Help(HashMap<String, Command> commands) {
        super("help", "Display a list of all possible commands.");
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("Here is a list of all possible commands and what they do:");
        commands.forEach((cmdName, cmd) -> System.out.println("- " + cmdName + ": " + cmd.getDescription()));
    }
}

