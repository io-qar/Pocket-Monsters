package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class North extends Command {
    public North() {
        super("north", "Move north.");
    }

    @Override
    public void execute(Player player, Map map, Game game, HashMap<String, Command> commands) {
        player.move(0, 1, map);
    }
}
