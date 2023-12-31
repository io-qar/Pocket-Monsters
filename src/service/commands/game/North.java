package service.commands.game;

import entity.Map;
import entity.Player;
import service.commands.Command;

public class North extends Command {
    private Player player;
    private Map map;
    public North(Player player, Map map) {
        super("north", "Move north.", false);
        this.player = player;
        this.map = map;
    }

    @Override
    public void execute() {
        player.move(0, 1, map);
    }
}
