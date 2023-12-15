package service.commands;

import entity.Map;
import entity.Player;

public class East extends Command {
    private Player player;
    private Map map;
    public East(Player player, Map map) {
        super("east", "Move east.", false);
        this.player = player;
        this.map = map;
    }

    @Override
    public void execute() {
        player.move(1, 0, map);
    }
}
