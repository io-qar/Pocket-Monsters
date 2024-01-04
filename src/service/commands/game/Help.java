package service.commands.game;

import service.commands.Command;

import java.util.HashMap;

public class Help extends Command {
    private HashMap<String, Command> commands;
    boolean inBattleContext;

    public Help(HashMap<String, Command> commands, boolean inBattleContext) {
        super("help", "Display a list of all possible "  + (inBattleContext ? "battle " : "") +  "commands.", false);
        this.commands = commands;
        this.inBattleContext = inBattleContext;
    }

    /**
     * Executes the help command
     */
    @Override
    public void execute() {
        System.out.println("Here is a list of all possible " + (inBattleContext ? "battle " : "") + "commands and what they do:");
        commands.forEach((cmdName, cmd) -> System.out.println("- " + cmdName + ": " + cmd.getDescription()));
    }
}

