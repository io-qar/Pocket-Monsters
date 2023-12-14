package service.commands;

import entity.Map;
import entity.Player;
import service.Game;

import java.util.HashMap;

public class Look extends Command {
    private Player player;
    public Look(Player player) {
        super("look", "Look around in your current location.");
        this.player = player;
    }

    @Override
    public void execute() {
        System.out.println(player.getCurrentLocation().lookAround());
    }
}