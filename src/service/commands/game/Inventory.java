package service.commands.game;

import entity.Player;
import service.commands.Command;

public class Inventory extends Command {
    private Player player;

    public Inventory(Player player) {
        super("inventory", "Display your pokemon.", false);
        this.player = player;
    }

    @Override
    public void execute() {
        player.displayInventory();
    }
}
