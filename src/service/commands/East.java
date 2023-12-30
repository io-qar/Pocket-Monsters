package service.commands;

import entity.Player;

public class East extends Command {
    private Player player;

    public East(Player player) {
        super("east", "Move east.", false);
        this.player = player;
    }

    @Override
    public void execute() {
        player.move(1, 0);
    }
}
