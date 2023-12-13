package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class East extends Command {
    public East() {
        super("east", "Move east.");
    }

    @Override
    public void execute(Player player, Map map, Game game, HashMap<String, Command> commands) {
        player.move(1, 0, map);
    }
}
