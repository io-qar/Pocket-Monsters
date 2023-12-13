package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class Help extends Command {
    public Help() {
        super("help", "Display a list of all possible commands.");
    }

    @Override
    public void execute(Player player, Map map, Game game, HashMap<String, Command> commands) {
        System.out.println("Here is a list of all possible commands and what they do:");
        commands.forEach((cmdName, cmd) -> System.out.println("- " + cmdName + ": " + cmd.getDescription()));
    }
}

