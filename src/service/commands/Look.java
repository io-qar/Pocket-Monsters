package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class Look extends Command {
    public Look() {
        super("look", "Look around in your current location.");
    }

    @Override
    public void execute(Player player, Map map, Game game, HashMap<String, Command> commands) {
        System.out.println(player.getCurrentLocation().lookAround());
    }
}