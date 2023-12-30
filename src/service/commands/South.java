package service.commands;

import entity.Player;

public class South extends Command {
    private Player player;

    public South(Player player) {
        super("south", "Move south.", false);
        this.player = player;
    }

    @Override
    public void execute() {
        player.move(0, -1);
    }
}
