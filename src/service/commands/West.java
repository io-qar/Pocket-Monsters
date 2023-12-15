package service.commands;

import entity.Map;
import entity.Player;

public class West extends Command {
    private Player player;
    private Map map;
    public West(Player player, Map map) {
        super("west", "Move west.", false);
        this.player = player;
        this.map = map;
    }

    @Override
    public void execute() {
        player.move(-1, 0, map);
    }
}
