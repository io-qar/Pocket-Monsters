package service.commands.game;

import entity.Player;
import service.commands.Command;


public class Look extends Command {
    private Player player;
    public Look(Player player) {
        super("look", "Look around in your current location.", false);
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println(player.getCurrentLocation().lookAround());
    }
}