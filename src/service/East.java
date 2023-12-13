package service;

import entity.Map;
import entity.Player;

public class East extends Command {
    public East() {
        super("east");
    }

    @Override
    public void execute(Player player, Map map, Game game) {
        player.move(1, 0, map);
    }
}
