package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class East extends Command {
    private Player player;
    private Map map;
    public East(Player player, Map map) {
        super("east", "Move east.");
        this.player = player;
        this.map = map;
    }

    @Override
    public void execute() {
        player.move(1, 0, map);
    }
}
