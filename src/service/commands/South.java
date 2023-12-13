package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class South extends Command {
    public South() {
        super("south", "Move south.");
    }

    @Override
    public void execute(Player player, Map map, Game game, HashMap<String, Command> commands) {
        player.move(0, -1, map);
    }
}
