package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class Exit extends Command {
    public Exit() {
        super("exit", "Exit the current game.");
    }

    @Override
    public void execute(Player player, Map map, Game game, HashMap<String, Command> commands) {
        game.stop();
    }
}
