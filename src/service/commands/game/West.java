package service.commands.game;

import entity.Map;
import entity.Player;
import service.commands.Command;

public class West extends Command {
    private Player player;
    private Map map;

    public West(Player player, Map map) {
        super("west", "Move west.", false);
        this.player = player;
        this.map = map;
    }

    /**
     * Executes the west command
     */
    @Override
    public void execute() {
        player.move(-1, 0, map);
    }
}
