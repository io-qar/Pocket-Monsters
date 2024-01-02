package service.commands.game;

import entity.Map;
import entity.Player;
import service.commands.Command;

public class South extends Command {
    private Player player;
    private Map map;

    public South(Player player, Map map) {
        super("south", "Move south.", false);
        this.player = player;
        this.map = map;
    }

    /**
     * Executes the south command
     */
    @Override
    public void execute() {
        player.move(0, -1, map);
    }
}
