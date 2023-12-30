package service.commands;

import entity.Player;

public class North extends Command {
    private Player player;

    public North(Player player) {
        super("north", "Move north.", false);
        this.player = player;
    }

    @Override
    public void execute() {
        player.move(0, 1);
    }
}
