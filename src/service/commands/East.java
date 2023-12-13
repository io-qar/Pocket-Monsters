package service.commands;

import entity.Map;
import entity.Player;
import service.Game;
import service.commands.Command;

public class East extends Command {
    public East() {
        super("east");
    }

    @Override
    public void execute(Player player, Map map, Game game) {
        player.move(1, 0, map);
    }
}
