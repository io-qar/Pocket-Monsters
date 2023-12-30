package service.commands;

import entity.Player;

public class West extends Command {
    private Player player;

    public West(Player player) {
        super("west", "Move west.", false);
        this.player = player;
    }

    @Override
    public void execute() {
        player.move(-1, 0);
    }
}
