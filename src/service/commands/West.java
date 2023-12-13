package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class West extends Command {
    public West() {
        super("west", "Move west.");
    }

    @Override
    public void execute(Player player, Map map, Game game, HashMap<String, Command> commands) {
        player.move(-1, 0, map);
    }
}
