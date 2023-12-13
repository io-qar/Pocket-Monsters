package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class Take extends Command {
    public Take() {
        super("take", "Pick up an item using 'take [item_name]'");
    }

    @Override
    public void execute(Player player, Map map, Game game, HashMap<String, Command> commands) {
        // implement...
        // player.takeItem(player.getCurrentLocation());
    }
}
