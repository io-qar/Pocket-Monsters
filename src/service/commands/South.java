package service.commands;

import entity.Map;
import entity.Player;
import service.Game;
import service.commands.Command;

public class South extends Command {
    public South() {
        super("south");
    }

    @Override
    public void execute(Player player, Map map, Game game) {
        player.move(0, -1, map);
    }
}
